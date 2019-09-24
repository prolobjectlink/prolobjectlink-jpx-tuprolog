#!/usr/bin/bash
kill $(jps -l | grep org.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole | awk '{print $1}')