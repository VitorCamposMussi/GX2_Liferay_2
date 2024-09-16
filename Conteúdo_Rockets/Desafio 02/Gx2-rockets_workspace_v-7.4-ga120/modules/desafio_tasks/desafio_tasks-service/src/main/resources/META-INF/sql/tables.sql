create table DESAFIO_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	dueDate DATE null,
	completed BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);