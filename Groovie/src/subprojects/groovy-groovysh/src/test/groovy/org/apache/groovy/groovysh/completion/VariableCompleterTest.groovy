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
package org.apache.groovy.groovysh.completion

import org.apache.groovy.groovysh.CompleterTestSupport
import org.apache.groovy.groovysh.Groovysh
import static org.apache.groovy.groovysh.completion.TokenUtilTest.tokenList

class VariableCompleterTest extends CompleterTestSupport {

    void testKnownVar() {
        groovyshMocker.demand.getInterp(1) { [context: [variables: [xyzabc: '']]] }
        groovyshMocker.use {
            Groovysh groovyshMock = new Groovysh()
            VariableSyntaxCompleter completer = new VariableSyntaxCompleter(groovyshMock)
            def candidates = []
            assert completer.complete(tokenList('xyz'), candidates)
            assert ['xyzabc'] == candidates
        }
    }

    void testKnownVarMultiple() {
        groovyshMocker.demand.getInterp(1) { [context: [variables: [bad: '', xyzabc: '', xyzfff: '', nope: '']]] }
        groovyshMocker.use {
            Groovysh groovyshMock = new Groovysh()
            VariableSyntaxCompleter completer = new VariableSyntaxCompleter(groovyshMock)
            def candidates = []
            assert completer.complete(tokenList('xyz'), candidates)
            assert ['xyzabc', 'xyzfff'] == candidates
        }
    }

    void testUnknownVar() {
        groovyshMocker.demand.getInterp(1) { [context: [variables: [:]]] }
        groovyshMocker.use {
            Groovysh groovyshMock = new Groovysh()
            VariableSyntaxCompleter completer = new VariableSyntaxCompleter(groovyshMock)
            def candidates = []
            assert [] == candidates
            assert !completer.complete(tokenList('xyz'), candidates)
        }
    }
}
