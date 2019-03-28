#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole ${1+"$@"}