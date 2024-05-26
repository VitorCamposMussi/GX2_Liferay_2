create table tasks_Task (
	taskId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	completed BOOLEAN,
	createDate DATE null
);