#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.pdb.prolog.tuprolog.TuPrologDatabaseConsole ${1+"$@"}