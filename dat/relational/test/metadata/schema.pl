'org.logicware.DatabaseUser'(sa,'',nil,false,false,nil,nil).

'org.logicware.prolog.PrologDatabaseFunction'(fn,'','dat\relational\test\functions.pl','org.logicware.util.ArrayList'(4,['X','Y','Z','R',nil,nil,nil,nil,nil,nil])).

'org.logicware.prolog.PrologDatabaseFunction'(fni,'','dat\relational\test\functions.pl','org.logicware.util.ArrayList'(4,['X','Y','Z','R',nil,nil,nil,nil,nil,nil])).

'org.logicware.prolog.PrologDatabaseFunction'(fnj,'','dat\relational\test\functions.pl','org.logicware.util.ArrayList'(4,['X','Y','Z','R',nil,nil,nil,nil,nil,nil])).

'org.logicware.prolog.PrologDatabaseFunction'(fnk,'','dat\relational\test\functions.pl','org.logicware.util.ArrayList'(4,['X','Y','Z','R',nil,nil,nil,nil,nil,nil])).

'org.logicware.DatabaseClass'('Address','',false,'Address',false,'','org.logicware.util.ArrayList'(0,[nil,nil,nil,nil,nil,nil,nil,nil,nil,nil]),'org.logicware.util.HashMap'(5,[nil,'org.logicware.util.HashMap$HashEntry'(state,'org.logicware.DatabaseField'(state,'',2,'java.lang.String',false,'Address.state',false,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(zip,'org.logicware.DatabaseField'(zip,'',3,'java.lang.String',false,'Address.zip',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(country,'org.logicware.DatabaseField'(country,'',4,'java.lang.String',false,'Address.country',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(city,'org.logicware.DatabaseField'(city,'',1,'java.lang.String',false,'Address.city',false,false,nil,nil,nil,nil,nil)),nil,'org.logicware.util.HashMap$HashEntry'(street,'org.logicware.DatabaseField'(street,'',0,'java.lang.String',false,'Address.street',false,false,nil,nil,nil,nil,nil)),nil,nil])).

'org.logicware.DatabaseClass'('Person','',false,'Person',false,'','org.logicware.util.ArrayList'(0,[nil,nil,nil,nil,nil,nil,nil,nil,nil,nil]),'org.logicware.util.HashMap'(12,['org.logicware.util.HashMap$HashEntry'(middleName,'org.logicware.DatabaseField'(middleName,'',2,'java.lang.String',false,'Person.middleName',false,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(lastLoginDate,'org.logicware.DatabaseField'(lastLoginDate,'',10,'java.util.Date',false,'Person.lastLoginDate',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(joinDate,'org.logicware.DatabaseField'(joinDate,'',9,'java.util.Date',false,'Person.joinDate',false,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(emails,'org.logicware.DatabaseField'(emails,'',6,'java.util.Collection',false,'Person.emails',false,false,'java.lang.String',nil,nil,nil,nil)),nil,nil,'org.logicware.util.HashMap$HashEntry'(address,'org.logicware.DatabaseField'(address,'',4,'org.logicware.domain.model.Address',false,'Person.address',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(birthDate,'org.logicware.DatabaseField'(birthDate,'',8,'java.util.Date',false,'Person.birthDate',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(loginCount,'org.logicware.DatabaseField'(loginCount,'',11,'java.lang.Integer',false,'Person.loginCount',false,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(nickNames,'org.logicware.DatabaseField'(nickNames,'',7,'java.util.Set',false,'Person.nickNames',false,false,'java.lang.String',nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(id,'org.logicware.DatabaseField'(id,'',0,'java.lang.Integer',false,'Person.id',true,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(firstName,'org.logicware.DatabaseField'(firstName,'',1,'java.lang.String',false,'Person.firstName',false,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(phones,'org.logicware.DatabaseField'(phones,'',5,'java.util.List',false,'Person.phones',false,false,'java.lang.String',nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(lastName,'org.logicware.DatabaseField'(lastName,'',3,'java.lang.String',false,'Person.lastName',false,false,nil,nil,nil,nil,nil))])).

'org.logicware.DatabaseClass'('Employee','',false,'Employee',false,'','org.logicware.util.ArrayList'(0,[nil,nil,nil,nil,nil,nil,nil,nil,nil,nil]),'org.logicware.util.HashMap'(2,[nil,nil,'org.logicware.util.HashMap$HashEntry'(department,'org.logicware.DatabaseField'(department,'',1,'org.logicware.domain.model.Department',false,'Employee.department',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(salary,'org.logicware.DatabaseField'(salary,'',0,'java.lang.Long',false,'Employee.salary',false,false,nil,nil,nil,nil,nil)),nil,nil,nil,nil,nil,nil,nil,nil,nil])).

'org.logicware.DatabaseClass'('Department','',false,'Department',false,'','org.logicware.util.ArrayList'(0,[nil,nil,nil,nil,nil,nil,nil,nil,nil,nil]),'org.logicware.util.HashMap'(3,[nil,nil,nil,nil,nil,nil,nil,nil,nil,'org.logicware.util.HashMap$HashEntry'(employeesByCubicle,'org.logicware.DatabaseField'(employeesByCubicle,'',2,'java.util.Map',false,'Department.employeesByCubicle',false,false,'org.logicware.domain.model.Employee',nil,nil,nil,nil)),nil,'org.logicware.util.HashMap$HashEntry'(id,'org.logicware.DatabaseField'(id,'',0,'java.lang.Integer',false,'Department.id',true,false,nil,nil,nil,nil,nil)),'org.logicware.util.HashMap$HashEntry'(name,'org.logicware.DatabaseField'(name,'',1,'java.lang.String',false,'Department.name',false,false,nil,nil,nil,nil,nil)),nil,nil,nil])).

'org.logicware.DatabaseSequence'(0,'org.logicware.domain.model.Address',adddress_sequence,1).

'org.logicware.DatabaseSequence'(0,'org.logicware.domain.model.Person',person_sequence,1).

'org.logicware.DatabaseSequence'(0,'org.logicware.domain.model.Employee',employee_sequence,1).

'org.logicware.DatabaseSequence'(0,'org.logicware.domain.model.Department',department_sequence,1).

'org.logicware.prolog.PrologDatabaseView'('org.logicware.domain.model.view.AnEmployeeView','','dat\relational\test\views.pl','org.logicware.util.ArrayList'(14,['Salary','Department','Id','FirstName','MiddleName','LastName','Address','Phones','Emails','NickNames','BirthDate','JoinDate','LastLoginDate','LoginCount',nil,nil,nil,nil,nil,nil])).
