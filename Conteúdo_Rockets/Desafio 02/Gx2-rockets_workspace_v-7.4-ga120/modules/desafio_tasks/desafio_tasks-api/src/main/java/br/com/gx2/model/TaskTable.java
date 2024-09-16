/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DESAFIO_Task&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskTable extends BaseTable<TaskTable> {

	public static final TaskTable INSTANCE = new TaskTable();

	public final Column<TaskTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TaskTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> dueDate = createColumn(
		"dueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Boolean> completed = createColumn(
		"completed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TaskTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TaskTable() {
		super("DESAFIO_Task", TaskTable::new);
	}

}