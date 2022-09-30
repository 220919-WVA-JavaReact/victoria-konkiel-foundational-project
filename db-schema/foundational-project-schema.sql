create table managers (
	man_id serial primary key,
	"first" varchar(25),
	"last" varchar(25),
	email varchar(50),
	department varchar(25)
);

create table employees(
	employee_id serial primary key,
	"first" varchar(25),
	"last" varchar(25),
	email varchar(50),
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

create table new_account(
	id serial primary key references employees,
	"first" varchar(25),
	"last" varchar(25),
	email varchar(50),
	department varchar(25)
);