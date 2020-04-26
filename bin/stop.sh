#!/usr/bin/bash
kill $(jps -l | grep io.github.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole | awk '{print $1}')