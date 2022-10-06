create table managers (
	man_id serial primary key,
	"first" varchar(25),
	"last" varchar(25),
	email varchar(50),
	username varchar(10),
	pw varchar(20),
	department varchar(25)
);

create table employees(
	employee_id serial primary key,
	"first" varchar(25),
	"last" varchar(25),
	email varchar(50),
	username varchar(10),
	pw varchar(20),
	department varchar(25),
	manager int references managers
);

create table rem_ticket(
	employee_id int references employees,
	man_id int references managers,
	amount decimal,
	description text,
	status varchar(10)
);

--Inserting mock data into managers table
insert into managers ("first", "last", email, username, pw, department) values ('Tilly', 'Karolczyk', 'tkarolczyk0@buzzfeed.com', 'tkarol0', 'bwIdR0ft', 'Sales');
insert into managers ("first", "last", email, username, pw, department) values ('Rab', 'Nettleship', 'rnettleship1@wix.com', 'rnett1', 'rCzg59ewCmxN', 'Legal');
insert into managers ("first", "last", email, username, pw, department) values ('Kent', 'Stoak', 'kstoak2@oaic.gov.au', 'kstoak2', 'Dk3WQ8Tf5o74', 'Marketing');
insert into managers ("first", "last", email, username, pw, department) values ('Elene', 'Donaldson', 'edonaldson3@comsenz.com', 'edon3', 'oHEDaMK', 'Marketing');
insert into managers ("first", "last", email, username, pw, department) values ('Colin', 'Shawcroft', 'cshawcroft4@cdc.gov', 'shawcroft4', 'bRMYJXFxh6', 'Business Development');
insert into managers ("first", "last", email, username, pw, department) values ('Arthur', 'Vescovo', 'avescovo5@boston.com', 'avescovo5', 'RIeNGzE2', 'Sales');
insert into managers ("first", "last", email, username, pw, department) values ('Marylin', 'Rickard', 'mrickard6@free.fr', 'mrickard6', 'E7OPJP4Itel', 'Marketing');
insert into managers ("first", "last", email, username, pw, department) values ('Hayyim', 'Simonds', 'hsimonds7@latimes.com', 'hsimonds7', 'eYYmoXg', 'Marketing');
insert into managers ("first", "last", email, username, pw, department) values ('Arleta', 'Stothard', 'astothard8@hc360.com', 'astothard8', 'VK3FT17b69', 'Business Development');
insert into managers ("first", "last", email, username, pw, department) values ('Jonas', 'Vanelli', 'jvanelli9@t-online.de', 'jvanelli9', 'rXuwxecoM', 'Services');

--Inserting mock data into employees table
insert into employees ("first", "last", email, username, pw, department, manager) values ('Erma', 'Keyes', 'ekeyes0@bigcartel.com', 'ekeyes0', 'r3YSg0AZ', 'Sales', 1);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Georges', 'Togher', 'gtogher1@google.com.hk', 'gtogher1', 'BUyHmSnAypEu', 'Marketing', 3);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Sisely', 'McKissack', 'smckissack2@surveymonkey.com', 'smckissa2', '8Zm1urt', 'Business Development', 5);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Jany', 'Aggs', 'jaggs3@earthlink.net', 'jaggs3', 'tZH44HGLjw', 'Business Development', 9);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Jodi', 'Coneley', 'jconeley4@miitbeian.gov.cn', 'jconeley4', 'mT7oqSd', 'Sales', 6);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Lukas', 'Gadsby', 'lgadsby5@mozilla.org', 'lgadsby5', 'a6eQry5qX0Ss', 'Services', 10);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Lyell', 'Shellcross', 'lshellcross6@reverbnation.com', 'lshell6', '8CEBUan4P8L', 'Marketing', 8);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Pat', 'Mardle', 'pmardle7@free.fr', 'pmardle7', '6dfRUA', 'Legal', 2);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Clair', 'Goeff', 'cgoeff8@rediff.com', 'cgoeff8', 'BXlo9jN', 'Marketing', 7);
insert into employees ("first", "last", email, username, pw, department, manager) values ('Raffaello', 'Gladbach', 'rgladbach9@sphinn.com', 'rgladbach9', 'aeow93HH', 'Marketing', 4);
