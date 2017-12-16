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

import org.logicware.jpi.ArityError;
import org.logicware.jpi.FunctorError;
import org.logicware.jpi.IndicatorError;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.PrologTerm;
import org.logicware.jpi.PrologVariable;

import alice.tuprolog.Var;

public class TuPrologVariable extends TuPrologTerm implements PrologVariable {

    TuPrologVariable(PrologProvider provider) {
	super(VARIABLE_TYPE, provider, new Var());
    }

    public TuPrologVariable(PrologProvider provider, String name) {
	super(VARIABLE_TYPE, provider, new Var(name));
    }

    public boolean isAnonymous() {
	return ((Var) value).isAnonymous();
    }

    public String getName() {
	return ((Var) value).getName();
    }

    public void setName(String name) {
	this.value = new Var(name);
    }

    @Override
    public PrologTerm[] getArguments() {
	return new TuPrologVariable[0];
    }

    @Override
    public int getArity() {
	throw new ArityError(this);
    }

    @Override
    public String getFunctor() {
	throw new FunctorError(this);
    }

    @Override
    public String getIndicator() {
	throw new IndicatorError(this);
    }

    @Override
    public boolean hasIndicator(String functor, int arity) {
	throw new IndicatorError(this);
    }

    public int getPosition() {
	throw new UnsupportedOperationException("getPosition()");
    }

    @Override
    public PrologTerm clone() {
	String n = getName();
	return new TuPrologVariable(provider, n);
    }

}
