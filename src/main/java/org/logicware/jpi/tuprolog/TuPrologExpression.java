/*
 * #%L
 * prolobjectlink-tuprolog
 * %%
 * Copyright (C) 2012 - 2017 Logicware Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.logicware.jpi.tuprolog;

import org.logicware.jpi.PrologExpression;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.PrologTerm;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;

public final class TuPrologExpression extends TuPrologTerm implements PrologExpression {

    @Deprecated
    TuPrologExpression(PrologProvider provider, PrologTerm left, String operator, PrologTerm right) {
	super(EXPRESSION_TYPE, provider);
	Term leftOperand = left.unwrap(TuPrologTerm.class).value;
	Term rightOperand = right.unwrap(TuPrologTerm.class).value;
	value = new Struct(operator, leftOperand, rightOperand);
    }

    @Deprecated
    TuPrologExpression(PrologProvider provider, Term left, String functor, Term right) {
	super(EXPRESSION_TYPE, provider, new Struct(functor, left, right));
    }

    public String getOperator() {
	return getFunctor();
    }

    public PrologTerm getLeft() {
	return toTerm(((Struct) value).getArg(0), PrologTerm.class);
    }

    public PrologTerm getRight() {
	return toTerm(((Struct) value).getArg(1), PrologTerm.class);
    }

    @Override
    public PrologTerm[] getArguments() {
	Struct structure = (Struct) value;
	int arity = structure.getArity();
	PrologTerm[] arguments = new PrologTerm[arity];
	for (int i = 0; i < arity; i++) {
	    arguments[i] = toTerm(structure.getArg(i), PrologTerm.class);
	}
	return arguments;
    }

    @Override
    public int getArity() {
	Struct structure = (Struct) value;
	return structure.getArity();
    }

    @Override
    public String getFunctor() {
	Struct structure = (Struct) value;
	return structure.getName();
    }

    @Override
    public String getIndicator() {
	return getFunctor() + "/" + getArity();
    }

    @Override
    public boolean hasIndicator(String functor, int arity) {
	return getFunctor().equals(functor) && getArity() == arity;
    }

    @Override
    public PrologTerm clone() {
	PrologTerm l = getLeft();
	String o = getOperator();
	PrologTerm r = getRight();
	return new TuPrologExpression(provider, l, o, r);
    }

}
