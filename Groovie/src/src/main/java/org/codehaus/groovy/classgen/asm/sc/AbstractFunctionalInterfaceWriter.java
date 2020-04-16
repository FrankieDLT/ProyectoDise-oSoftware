/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.classgen.asm.sc;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.classgen.asm.BytecodeHelper;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.codehaus.groovy.ast.ClassHelper.getWrapper;
import static org.codehaus.groovy.transform.stc.StaticTypesMarker.INFERRED_FUNCTIONAL_INTERFACE_TYPE;
import static org.codehaus.groovy.transform.stc.StaticTypesMarker.PARAMETER_TYPE;

/**
 * Represents functional interface writer which contains some common methods to complete generating bytecode
 * @since 3.0.0
 */
public interface AbstractFunctionalInterfaceWriter {
    String ORIGINAL_PARAMETERS_WITH_EXACT_TYPE = "__ORIGINAL_PARAMETERS_WITH_EXACT_TYPE";

    default ClassNode getFunctionalInterfaceType(Expression expression) {
        ClassNode type = expression.getNodeMetaData(PARAMETER_TYPE);

        if (null == type) {
            type = expression.getNodeMetaData(INFERRED_FUNCTIONAL_INTERFACE_TYPE);
        }
        return type;
    }

    default String createMethodDescriptor(MethodNode abstractMethodNode) {
        return BytecodeHelper.getMethodDescriptor(
                abstractMethodNode.getReturnType().getTypeClass(),
                Arrays.stream(abstractMethodNode.getParameters())
                        .map(e -> e.getType().getTypeClass())
                        .toArray(Class[]::new)
        );
    }

    default Handle createBootstrapMethod(boolean isInterface, boolean serializable) {
        if (serializable) {
            return new Handle(
                    Opcodes.H_INVOKESTATIC,
                    "java/lang/invoke/LambdaMetafactory",
                    "altMetafactory",
                    "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;",
                    isInterface
            );
        }

        return new Handle(
                Opcodes.H_INVOKESTATIC,
                "java/lang/invoke/LambdaMetafactory",
                "metafactory",
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                isInterface
        );
    }

    default Object[] createBootstrapMethodArguments(String abstractMethodDesc, int insn, ClassNode methodOwnerClassNode, MethodNode methodNode, boolean serializable) {
        Parameter[] parameters = methodNode.getNodeMetaData(ORIGINAL_PARAMETERS_WITH_EXACT_TYPE);
        List<Object> argumentList = new LinkedList<>();

        argumentList.add(Type.getType(abstractMethodDesc));
        argumentList.add(
                new Handle(
                        insn,
                        BytecodeHelper.getClassInternalName(methodOwnerClassNode.getName()),
                        methodNode.getName(),
                        BytecodeHelper.getMethodDescriptor(methodNode),
                        methodOwnerClassNode.isInterface()
                )
        );
        argumentList.add(Type.getType(BytecodeHelper.getMethodDescriptor(methodNode.getReturnType(), parameters)));

        if (serializable) {
            argumentList.add(5);
            argumentList.add(0);
        }

        return argumentList.toArray();
    }

    default ClassNode convertParameterType(ClassNode parameterType, ClassNode inferredType) {
        ClassNode type;
        boolean isParameterTypePrimitive = ClassHelper.isPrimitiveType(parameterType);
        boolean isInferredTypePrimitive = ClassHelper.isPrimitiveType(inferredType);
        if (!isParameterTypePrimitive && isInferredTypePrimitive) {
            // The non-primitive type and primitive type are not allowed to mix since Java 9+
            // java.lang.invoke.LambdaConversionException: Type mismatch for instantiated parameter 0: int is not a subtype of class java.lang.Object
            type = getWrapper(inferredType);
        } else if (isParameterTypePrimitive && !isInferredTypePrimitive) {
            // The non-primitive type and primitive type are not allowed to mix since Java 9+
            // java.lang.invoke.LambdaConversionException: Type mismatch for instantiated parameter 0: class java.lang.Integer is not a subtype of int
            type = ClassHelper.getUnwrapper(inferredType);
        } else {
            type = inferredType;
        }
        return type;
    }

    default Parameter prependParameter(List<Parameter> methodParameterList, String parameterName, ClassNode parameterType) {
        Parameter parameter = new Parameter(parameterType, parameterName);

        parameter.setOriginType(parameterType);
        parameter.setClosureSharedVariable(false);

        methodParameterList.add(0, parameter);

        return parameter;
    }
}
