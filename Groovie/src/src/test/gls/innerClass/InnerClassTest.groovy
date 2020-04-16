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
package gls.innerClass

import groovy.test.NotYetImplemented
import org.codehaus.groovy.control.CompilationFailedException
import org.junit.Test

import static groovy.test.GroovyAssert.assertScript
import static groovy.test.GroovyAssert.shouldFail

final class InnerClassTest {

    @Test
    void testTimerAIC() {
        assertScript '''
            import java.util.concurrent.CountDownLatch
            import java.util.concurrent.TimeUnit

            CountDownLatch called = new CountDownLatch(1)

            Timer timer = new Timer()
            timer.schedule(new TimerTask() {
                void run() {
                    called.countDown()
                }
            }, 0)

            assert called.await(10, TimeUnit.SECONDS)
        '''
    }

    @Test
    void testAICReferenceInClosure() {
        assertScript '''
            def y = [true]
            def o = new Object() {
              def foo() {
                def c = {
                  assert y[0]
                }
                c()
              }
            }
            o.foo()
        '''
    }

    @Test
    void testExtendsObjectAndAccessAFinalVariableInScope() {
        assertScript '''
            final String objName = "My name is Guillaume"

            assert new Object() {
                String toString() { objName }
            }.toString() == objName
        '''
    }

    @Test
    void testExtendsObjectAndReferenceAMethodParameterWithinAGString() {
        assertScript '''
            Object makeObj0(String name) {
                new Object() {
                    String toString() { "My name is \${name}" }
                }
            }

            assert makeObj0("Guillaume").toString() == "My name is Guillaume"
        '''
    }

    @Test
    void testExtendsObjectAndReferenceAGStringPropertyDependingOnAMethodParameter() {
        assertScript '''
            Object makeObj1(String name) {
                 new Object() {
                    String objName = "My name is \${name}"

                    String toString() { objName }
                 }
            }

            assert makeObj1("Guillaume").toString() == "My name is Guillaume"
        '''
    }

    @Test
    void testUsageOfInitializerBlockWithinAnAIC() {
        assertScript '''
            Object makeObj2(String name) {
                 new Object() {
                    String objName
                    // initializer block
                    {
                        objName = "My name is " + name
                    }

                    String toString() {
                        objName
                    }
                 }
            }

            assert makeObj2("Guillaume").toString() == "My name is Guillaume"
        '''
    }

    @Test // GROOVY-8423
    void testPrivateInnerClassHasPrivateModifier() {
        assertScript '''
            import static java.lang.reflect.Modifier.*

            class A {
                private class B {}
            }

            int modifiers = A.B.modifiers
            assert isPrivate(modifiers)
        '''
    }

    @Test // GROOVY-8423
    void testProtectedInnerClassHasProtectedModifier() {
        assertScript '''
            import static java.lang.reflect.Modifier.*

            class A {
                protected class B {}
            }

            int modifiers = A.B.modifiers
            assert isProtected(modifiers)
        '''
    }

    @Test // GROOVY-8423
    void testPackagePrivateInnerClassHasProtectedModifier() {
        assertScript '''
            import static java.lang.reflect.Modifier.*

            class A {
                @groovy.transform.PackageScope class B {}
            }

            int modifiers = A.B.modifiers
            assert !isPrivate(modifiers) && !isProtected(modifiers) && !isPublic(modifiers)
        '''
    }

    @Test
    void testStaticInnerClass() {
        assertScript '''
            import static java.lang.reflect.Modifier.*

            class A {
                static class B {}
            }
            def b = new A.B()
            assert b != null

            int modifiers = A.B.modifiers
            assert isPublic(modifiers)
        '''
    }

    @Test
    void testStaticInnerClass2() {
        assertScript '''
            class A {
                static class B{}
            }
            assert A.declaredClasses.length==1
            assert A.declaredClasses[0]==A.B
        '''
    }

    @Test
    void testNonStaticInnerClass() {
        assertScript '''
            class A {
                class B {
                    final String foo = 'foo'
                }
            }
            def b = new A.B(new A())
            assert b.foo == 'foo'
        '''
    }

    @Test @NotYetImplemented
    void testNonStaticInnerClass2() {
        shouldFail CompilationFailedException, '''
            class A {
                class B {}
            }
            def x = new A.B() // requires reference to A
        '''
    }

    @Test
    void testAnonymousInnerClass() {
        assertScript '''
            class Foo {}

            def x = new Foo(){
                def bar() { 1 }
            }
            assert x.bar() == 1
        '''
    }

    @Test
    void testLocalVariable() {
        assertScript '''
            class Foo {}
            final val = 2
            def x = new Foo() {
              def bar() { val }
            }
            assert x.bar() == val
            assert x.bar() == 2
        '''
    }

    @Test
    void testConstructor() {
        shouldFail CompilationFailedException, '''
            class Foo {}
            def x = new Foo() {
                Foo() {}
            }
        '''
    }

    @Test
    void testUsageOfOuterField() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private x = 1

                def foo() {
                    def runner = new Run() {
                        def run() { return x }
                    }
                    runner.run()
                }

                void x(y) { x = y }
            }
            def foo = new Foo()
            assert foo.foo() == 1
            foo.x(2)
            assert foo.foo() == 2
        '''
    }

    @Test
    void testUsageOfOuterField2() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x = 1

                static foo() {
                    def runner = new Run() {
                        def run() { return x }
                    }
                    runner.run()
                }

                static x(y) { x = y }
            }
            assert Foo.foo() == 1
            Foo.x(2)
            assert Foo.foo() == 2
        '''
    }

    @Test
    void testUsageOfOuterField3() {
        assertScript '''
            interface X {
                def m()
            }

            class A {
                def pm = "pm"

                def bar(x) {x().m()}
                def foo() {
                    bar { ->
                        return new X() {
                            def m() { pm }
                        }
                    }
                }
            }
            def a = new A()
            assert "pm" == a.foo()
        '''
    }

    @Test // GROOVY-6141
    void testUsageOfOuterField4() {
        assertScript '''
            class A {
                def x = 1
                def b = new B()
                class B {
                    def y = 2
                    def c = new C()
                    def f () {
                        assert y==2
                        assert x==1
                    }
                    class C {
                        def z = 3
                        def f() {
                            assert z==3
                            assert y==2
                            assert x==1
                        }
                    }
                }
            }

            def a = new A()
            a.b.f()
            a.b.c.f()
        '''
    }

    @Test // GROOVY-9189
    void testUsageOfOuterField5() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x = 1

                static foo(def runner = new Run() {
                    def run() { return x }
                }) {
                    runner.run()
                }

                static x(y) { x = y }
            }
            assert Foo.foo() == 1
            Foo.x(2)
            assert Foo.foo() == 2
        '''
    }

    @Test // GROOVY-9168
    void testUsageOfOuterField6() {
        assertScript '''
            class A {
                //                  AIC in this position can use static properties:
                A(Runnable action = new Runnable() { void run() { answer = 42 }}) {
                    this.action = action
                }
                Runnable   action
                static int answer
            }

            def a = new A()
            a.action.run();
            assert a.answer == 42
        '''
    }

    @Test
    void testUsageOfOuterFieldOverridden() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private x = 1

                def foo() {
                    def runner = new Run() {
                        def run() { return x } // <-- dynamic variable
                    }
                    runner.run()
                }

                void setX(val) { x = val }
            }
            class Bar extends Foo {
                def x = 'string' // hides 'foo.@x' and overrides 'foo.setX(val)'
            }
            def bar = new Bar()
            assert bar.foo() == 'string'
            bar.x = 'new string'
            assert bar.foo() == 'new string'
        '''
    }

    @Test
    void testUsageOfOuterMethod() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private x() { return 1 }

                def foo() {
                    def runner = new Run(){
                        def run() { return x() }
                    }
                    runner.run()
                }
            }
            def foo = new Foo()
            assert foo.foo() == 1
        '''
    }

    @Test
    void testUsageOfOuterMethod2() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x() { return 1 }

                def foo() {
                    def runner = new Run() {
                        def run() { return x() }
                    }
                    runner.run()
                }
            }
            def foo = new Foo()
            assert foo.foo() == 1
        '''
    }

    @Test
    void testUsageOfOuterMethod3() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x() { return 1 }

                def foo(def runner = new Run() {
                    def run() { return x() }
                }) {
                    runner.run()
                }
            }
            def foo = new Foo()
            assert foo.foo() == 1
        '''
    }

    @Test // GROOVY-9189
    void testUsageOfOuterMethod4() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x() { return 1 }

                static def foo(def runner = new Run() {
                    def run() { return x() }
                }) {
                    runner.run()
                }
            }
            def foo = new Foo()
            assert foo.foo() == 1
        '''
    }

    @Test // GROOVY-9168
    void testUsageOfOuterMethod5() {
        assertScript '''
            class A {
                //                  AIC in this position can use static methods:
                A(Runnable action = new Runnable() { void run() { setAnswer(42) }}) {
                    this.action = action
                }
                Runnable action
                static int answer
            }

            def a = new A()
            a.action.run();
            assert a.answer == 42
        '''
    }

    @Test
    void testUsageOfOuterMethodOverridden() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private x() { return 1 }

                def foo() {
                    def runner = new Run() {
                        def run() { return x() }
                    }
                    runner.run()
                }
            }
            class Bar extends Foo {
                def x() { return 2 }
            }
            def bar = new Bar()
            assert bar.foo() == 1
        '''
    }

    @Test
    void testUsageOfOuterMethodOverridden2() {
        assertScript '''
            interface Run {
                def run()
            }
            class Foo {
                private static x() { return 1 }

                static foo() {
                    def runner = new Run() {
                        def run() { return x() }
                    }
                    runner.run()
                }
            }
            class Bar extends Foo {
                static x() { return 2 }
            }
            def bar = new Bar()
            assert bar.foo() == 1
        '''
    }

    @Test
    void testClassOutputOrdering() {
        // this does actually not do much, but before this
        // change the inner class was tried to be executed
        // because a class ordering bug. The main method
        // makes the Foo class executeable, but Foo$Bar is
        // not. So if Foo$Bar is returned, asserScript will
        // fail. If Foo is returned, asserScript will not
        // fail.
        assertScript '''
            class Foo {
                static class Bar{}
                static main(args){}
            }
        '''
    }

    @Test
    void testInnerClassDotThisUsage() {
        assertScript '''
            class A{
                int x = 0;
                class B{
                    int y = 2;
                    class C {
                        void foo() {
                          A.this.x  = 1
                          A.B.this.y = 2*B.this.y;
                        }
                    }
                }
            }
            def a = new A()
            def b = new A.B(a)
            def c = new A.B.C(b)
            c.foo()
            assert a.x == 1
            assert b.y == 4
        '''
    }

    @Test
    void testInnerClassDotThisUsage2() {
        assertScript '''
            interface X {
                def m()
            }

            class A {
                def foo() {
                    def c = {
                        return new X(){def m(){
                            A.this
                         } }
                    }
                    return c().m()
                }
            }
            class B extends A {}
            def b = new B()
            assert b.foo() instanceof B
        '''
    }

    @Test
    void testImplicitThisPassingWithNamedArguments() {
        def oc = new MyOuterClass4028()
        assert oc.foo().propMap.size() == 2
    }

    @Test
    void testThis0() {
        assertScript '''
            class A {
                static def field = 10
                void main (a) {
                    new C ().r ()
                }

                class C {
                    def r () {
                        4.times {
                            new B(it).u (it)
                        }
                    }
                }

                class B {
                    def s
                    B (s) { this.s = s}
                    def u (i) { println i + s + field }
                }
            }
        '''
    }

    @Test
    void testReferencedVariableInAIC() {
        assertScript '''
            interface X {}

            final double delta = 0.1
            (0 ..< 1).collect { n ->
                new X () {
                    Double foo () {
                        delta
                    }
                }
            }
        '''
    }

    @Test
    void testReferencedVariableInAIC2() {
        assertScript '''
            interface X {}

            final double delta1 = 0.1
            final double delta2 = 0.1
            (0 ..< 1).collect { n ->
                new X () {
                    Double foo () {
                        delta1 + delta2
                    }
                }
            }
        '''
    }

    @Test // GROOVY-5989
    void testReferenceToOuterClassNestedInterface() {
        assertScript '''
            interface Koo { class Inner { } }

            class Usage implements Koo {
                static class MyInner extends Inner { }
            }

            assert new Usage() != null
        '''
    }

    @Test // GROOVY-5679, GROOVY-5681
    void testEnclosingMethodIsSet() {
        assertScript '''
            import groovy.transform.ASTTest
            import org.codehaus.groovy.ast.expr.*
            import static org.codehaus.groovy.classgen.Verifier.*
            import static org.codehaus.groovy.control.CompilePhase.*

            class A {
                @ASTTest(phase=CLASS_GENERATION, value={
                    def initialExpression = node.parameters[0].getNodeMetaData(INITIAL_EXPRESSION)
                    assert initialExpression instanceof ConstructorCallExpression
                    def icn = initialExpression.type
                    assert icn instanceof org.codehaus.groovy.ast.InnerClassNode
                    assert icn.enclosingMethod != null
                    assert icn.enclosingMethod.name == 'bar'
                    assert icn.enclosingMethod.parameters.length == 0 // ensure the enclosing method is bar(), not bar(Object)
                })
                void bar(action = new Runnable() { void run() { x = 123 }}) {
                    action.run()
                }
                int x
            }
            def a = new A()
            a.bar()
            assert a.x == 123
        '''
    }

    @Test // GROOVY-5681, GROOVY-9151
    void testEnclosingMethodIsSet2() {
        assertScript '''
            import groovy.transform.ASTTest
            import org.codehaus.groovy.ast.expr.*
            import static org.codehaus.groovy.classgen.Verifier.*
            import static org.codehaus.groovy.control.CompilePhase.*

            @ASTTest(phase=CLASS_GENERATION, value={
                def init = node.parameters[0].getNodeMetaData(INITIAL_EXPRESSION)
                assert init instanceof MapExpression
                assert init.mapEntryExpressions[0].valueExpression instanceof ConstructorCallExpression
                def type = init.mapEntryExpressions[0].valueExpression.type

                assert type.enclosingMethod != null
                assert type.enclosingMethod.name == 'bar'
                assert type.enclosingMethod.parameters.length == 0 // ensure the enclosing method is bar(), not bar(Map)
            })
            void bar(Map args = [action: new Runnable() { void run() { result = 123 }}]) {
                args.action.run()
            }

            bar()
        '''
    }

    @Test // GROOVY-5681, GROOVY-9151
    void testEnclosingMethodIsSet3() {
        assertScript '''
            import groovy.transform.ASTTest
            import org.codehaus.groovy.ast.expr.*
            import org.codehaus.groovy.ast.stmt.*
            import static org.codehaus.groovy.classgen.Verifier.*
            import static org.codehaus.groovy.control.CompilePhase.*

            @ASTTest(phase=CLASS_GENERATION, value={
                def init = node.parameters[0].getNodeMetaData(INITIAL_EXPRESSION)
                assert init instanceof ConstructorCallExpression
                assert init.type.enclosingMethod != null
                assert init.type.enclosingMethod.name == 'bar'
                assert init.type.enclosingMethod.parameters.length == 0 // ensure the enclosing method is bar(), not bar(Runnable)

                assert init.type.getMethods('run')[0].code instanceof BlockStatement
                assert init.type.getMethods('run')[0].code.statements[0] instanceof ExpressionStatement
                assert init.type.getMethods('run')[0].code.statements[0].expression instanceof DeclarationExpression

                init = init.type.getMethods('run')[0].code.statements[0].expression.rightExpression
                assert init instanceof ConstructorCallExpression
                assert init.isUsingAnonymousInnerClass()
                assert init.type.enclosingMethod != null
                assert init.type.enclosingMethod.name == 'run'
                assert init.type.enclosingMethod.parameters.length == 0
            })
            void bar(Runnable runner = new Runnable() {
                @Override void run() {
                    def comparator = new Comparator<int>() {
                        int compare(int one, int two) {
                        }
                    }
                }
            }) {
                args.action.run()
            }
        '''
    }

    @Test // GROOVY-6810
    void testThisReferenceForAICInOpenBlock() {
        assertScript '''
            import java.security.AccessController
            import java.security.PrivilegedAction

            static void injectVariables(final def instance, def variables) {
                instance.class.declaredFields.each { field ->
                    if (variables[field.name]) {
                        AccessController.doPrivileged(new PrivilegedAction() {
                            @Override
                            Object run() {
                                boolean wasAccessible = field.isAccessible()
                                try {
                                    field.accessible = true
                                    field.set(instance, variables[field.name])
                                    return null; // return nothing...
                                } catch (IllegalArgumentException | IllegalAccessException ex) {
                                    throw new IllegalStateException("Cannot set field: " + field, ex)
                                } finally {
                                    field.accessible = wasAccessible
                                }
                            }
                        })
                    }
                }
            }

            class Test {def p}
            def t = new Test()
            injectVariables(t, ['p': 'q'])
        '''
    }

    @Test // GROOVY-4896
    void testThisReferenceForAICInOpenBlock2() {
        assertScript '''
            def doSomethingUsingLocal(){
                logExceptions {
                    String s1 = "Ok"
                    Runnable ifA = new Runnable(){
                        void run(){
                            s1.toString()
                        }
                    }
                    ifA.run()
                }
            }

            def doSomethingUsingParamWorkaround(final String s2){
                logExceptions {
                    String s1=s2
                    Runnable ifA = new Runnable(){
                        void run(){
                            s1.toString()
                        }
                    }
                    ifA.run()
                }
            }

            def doSomethingUsingParam(final String s1){ // This always fails
                logExceptions {
                    Runnable ifA = new Runnable(){
                        void run(){
                            s1.toString()
                        }
                    }
                    ifA.run()
                }
            }

            def doSomethingEmptyRunnable(final String s1){
                logExceptions {
                    Runnable ifA = new Runnable(){
                        void run(){
                        }
                    }
                    ifA.run()
                }
            }


            def logExceptions(Closure c){
                try{
                    c.call()
                } catch (Throwable e){
                    return false
                }
                return true
            }

            assert doSomethingUsingLocal()
            assert doSomethingEmptyRunnable("")
            assert doSomethingUsingParamWorkaround("Workaround")
            assert doSomethingUsingParam("anyString")
        '''
    }

    @Test // GROOVY-5582
    void testAICExtendingAbstractInnerClass() {
        assertScript '''
            class Outer {
                int outer() { 1 }
                abstract class Inner {
                    abstract int inner()
                }
                int test() {
                    Inner inner = new Inner() {
                        int inner() { outer() }
                    }
                    inner.inner()
                }
            }
            assert new Outer().test() == 1
        '''
    }

    @Test // GROOVY-6831
    void testNestedPropertyHandling() {
        assertScript '''
            class Outer {
                private static List items = []
                void add() { items.add('Outer') }
                static class Nested {
                    void add() { items.add('Nested') }
                    static class NestedNested {
                        void add() { items.add('NestedNested') }
                        void set() { items = ['Overridden'] }
                    }
                }
            }
            new Outer().add()
            new Outer.Nested().add()
            new Outer.Nested.NestedNested().add()
            assert Outer.items == ["Outer", "Nested", "NestedNested"]
            new Outer.Nested.NestedNested().set()
            assert Outer.items == ["Overridden"]
        '''
    }

    @Test // GROOVY-7312
    void testInnerClassOfInterfaceIsStatic() {
        assertScript '''
            import java.lang.reflect.Modifier
            interface Baz {
                class Pls {}
            }

            assert Modifier.isStatic(Baz.Pls.modifiers)
        '''
    }

    @Test // GROOVY-7312
    void testInnerClassOfInterfaceIsStatic2() {
        assertScript '''
            import java.lang.reflect.Modifier
            import groovy.transform.ASTTest
            import org.codehaus.groovy.control.CompilePhase
            import org.objectweb.asm.Opcodes

            @ASTTest(phase = CLASS_GENERATION, value = {
                assert node.innerClasses.every { it.modifiers & Opcodes.ACC_STATIC }
            })
            interface Baz {
                def foo = { "bar" }
            }
            null
        '''
    }

    @Test // GROOVY-8914
    void testNestedClassInheritingFromNestedClass() {
        // control
        assert new Outer8914.Nested()

        assertScript '''
            class OuterReferencingPrecompiled {
                static class Nested extends gls.innerClass.Parent8914.Nested {}
            }
            assert new OuterReferencingPrecompiled.Nested()
        '''
    }

    @Test // GROOVY-6809
    void testReferenceToUninitializedThis() {
        def err = shouldFail '''
            class Test {
                static main(args) {
                    def a = new A()
                }

                static class A {
                    A() {
                        def b = new B()
                    }

                    class B extends A {
                        B() {
                            super(A.this)
                        }
                    }
                }
            }
        '''

        assert err =~ / Could not find matching constructor for: Test.A\(Test.A\)/
    }

    @Test // GROOVY-6809
    void testReferenceToUninitializedThis2() {
        assertScript '''
            class A {
                A() {
                    this(new Runnable() {
                        @Override
                        void run() {
                        }
                    })
                }

                private A(Runnable action) {
                }
            }

            new A()
        '''
    }

    @Test // GROOVY-6809
    void testReferenceToUninitializedThis3() {
        assertScript '''
            class A {
                A(x) {
                }
            }
            class B extends A {
              B() {
                super(new Object() {})
              }
            }

            new B()
        '''
    }

    @Test // GROOVY-9168
    void testReferenceToUninitializedThis4() {
        def err = shouldFail '''
            class Outer {
              class Inner {
              }
              Outer(Inner inner) {
              }
              Outer() {
                  this(new Inner())
              }
            }
            new Outer()
        '''

        assert err =~ / Cannot reference 'this' before supertype constructor has been called. /
    }

    @Test // GROOVY-9168
    void testReferenceToUninitializedThis5() {
        def err = shouldFail '''
            class Outer {
              class Inner {
              }
              Outer(Inner inner = new Inner()) {
              }
            }
            new Outer()
        '''

        assert err =~ / Cannot reference 'this' before supertype constructor has been called. /
    }

    @Test // GROOVY-9168
    void testReferenceToUninitializedThis6() {
        assertScript '''
            import groovy.transform.ASTTest
            import java.util.concurrent.Callable
            import org.codehaus.groovy.ast.expr.*
            import static org.codehaus.groovy.classgen.Verifier.*
            import static org.codehaus.groovy.control.CompilePhase.*

            class A {
                @ASTTest(phase=CLASS_GENERATION, value={
                    def init = node.parameters[0].getNodeMetaData(INITIAL_EXPRESSION)
                    assert init instanceof ConstructorCallExpression
                    assert init.isUsingAnonymousInnerClass()
                    assert init.type.enclosingMethod != null
                    assert init.type.enclosingMethod.name == '<init>'
                    assert init.type.enclosingMethod.parameters.length == 0 // ensure the enclosing method is A(), not A(Runnable)
                })
                A(Callable action = new Callable() { def call() { return 42 }}) {
                    this.action = action
                }
                Callable action
            }

            def a = new A()
            assert a.action.call() == 42
        '''
    }
}

//------------------------------------------------------------------------------

class Parent8914 {
    static class Nested {}
}

class Outer8914 {
    static class Nested extends Parent8914.Nested {}
}

class MyOuterClass4028 {
    def foo() {
        new MyInnerClass4028(fName: 'Roshan', lName: 'Dawrani')
    }
    class MyInnerClass4028 {
        Map propMap
        def MyInnerClass4028(Map propMap) {
            this.propMap = propMap
        }
    }
}
