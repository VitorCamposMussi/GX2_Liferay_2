/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package tasks.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import tasks.model.Task;
import tasks.service.base.TaskLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Vitor
 */
@Component(
	property = "model.class.name=tasks.model.Task", service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	public Task addTask(String title, String description) {
		long taskId = counterLocalService.increment();
		Task task = taskPersistence.create(taskId);

		task.setTitle(title);
		task.setDescription(description);
		task.setCompleted(false);
		task.setCreateDate(new java.util.Date());

		taskPersistence.update(task);

		return task;
	}

	public List<Task> getTasks() {
		return taskPersistence.findAll();
	}
}