/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package tasks.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Task service. Represents a row in the &quot;tasks_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>tasks.model.impl.TaskModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>tasks.model.impl.TaskImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
@ProviderType
public interface TaskModel extends BaseModel<Task> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task model instance should use the {@link Task} interface instead.
	 */

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the title of this task.
	 *
	 * @return the title of this task
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this task.
	 *
	 * @param title the title of this task
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this task.
	 *
	 * @return the description of this task
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this task.
	 *
	 * @param description the description of this task
	 */
	public void setDescription(String description);

	/**
	 * Returns the completed of this task.
	 *
	 * @return the completed of this task
	 */
	public boolean getCompleted();

	/**
	 * Returns <code>true</code> if this task is completed.
	 *
	 * @return <code>true</code> if this task is completed; <code>false</code> otherwise
	 */
	public boolean isCompleted();

	/**
	 * Sets whether this task is completed.
	 *
	 * @param completed the completed of this task
	 */
	public void setCompleted(boolean completed);

	/**
	 * Returns the create date of this task.
	 *
	 * @return the create date of this task
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this task.
	 *
	 * @param createDate the create date of this task
	 */
	public void setCreateDate(Date createDate);

	@Override
	public Task cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}