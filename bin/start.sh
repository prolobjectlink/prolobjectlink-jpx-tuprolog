#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole -m
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole -z 9110