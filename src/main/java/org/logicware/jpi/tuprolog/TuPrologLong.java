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
import org.logicware.jpi.PrologDouble;
import org.logicware.jpi.PrologFloat;
import org.logicware.jpi.PrologInteger;
import org.logicware.jpi.PrologLong;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.PrologTerm;

import alice.tuprolog.Long;
import alice.tuprolog.Term;

public class TuPrologLong extends TuPrologTerm implements PrologLong {

    TuPrologLong(PrologProvider provider) {
	super(LONG_TYPE, provider, new Long(0));
    }

    TuPrologLong(PrologProvider provider, Number value) {
	super(LONG_TYPE, provider, new Long(value.longValue()));
    }

    public PrologInteger getPrologInteger() {
	return new TuPrologInteger(provider, getIntValue());
    }

    public PrologFloat getPrologFloat() {
	return new TuPrologFloat(provider, getFloatValue());
    }

    public PrologDouble getPrologDouble() {
	return new TuPrologDouble(provider, getDoubleValue());
    }

    public PrologLong getPrologLong() {
	return new TuPrologLong(provider, getLongValue());
    }

    public long getLongValue() {
	return ((Long) value).longValue();
    }

    public double getDoubleValue() {
	return ((Long) value).doubleValue();
    }

    public int getIntValue() {
	return ((Long) value).intValue();
    }

    public float getFloatValue() {
	return ((Long) value).floatValue();
    }

    @Override
    public PrologTerm[] getArguments() {
	return new TuPrologLong[0];
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

    @Override
    public PrologTerm clone() {
	long l = getLongValue();
	return new TuPrologLong(provider, l);
    }

}
