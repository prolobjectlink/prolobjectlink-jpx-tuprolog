@echo off
FOR /F "tokens=1,2 delims= " %%G IN ('jps -l') DO IF %%H==io.github.prolobjectlink.db.prolog.tuprolog.TuPrologDatabaseConsole taskkill /F /PID %%G