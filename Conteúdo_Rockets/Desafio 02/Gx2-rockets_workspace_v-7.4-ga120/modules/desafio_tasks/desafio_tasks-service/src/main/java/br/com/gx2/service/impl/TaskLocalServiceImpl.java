package br.com.gx2.service.impl;

import br.com.gx2.exception.NoSuchTaskException;
import br.com.gx2.model.Task;
import br.com.gx2.service.base.TaskLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * Custom CRUD implementation for Task entity
 */
@Component(
        property = "model.class.name=br.com.gx2.model.Task",
        service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

    // 1 - Método para criar nova tarefa
    public Task createTask(
            String title, String description, Date dueDate, boolean completed,
            ServiceContext serviceContext) throws PortalException {

        long taskId = counterLocalService.increment(Task.class.getName());

        Task task = taskLocalService.createTask(taskId);

        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(completed);

        taskLocalService.addTask(task);

        return task;
    }


    // 2 - Método para apagar uma tarefa de acordo com o id fornecido
    public Task deleteTask(long taskId) throws PortalException {
        Task task = taskLocalService.getTask(taskId);

        if (Validator.isNull(task)) {
            throw new NoSuchTaskException("Task with taskId " + taskId + " not found");
        }

        return taskLocalService.deleteTask(task);
    }

    // 3 - Método para listar todas as tarefas
    public List<Task> getAllTasks() {
        return taskLocalService.getTasks(-1, -1);
    }

    // 4 - Método para listar uma tarefa de acordo com o ID fornecido
    public Task getTaskById(long taskId) throws PortalException {
        return taskLocalService.getTask(taskId);
    }

    // 5 - Método para atualizar uma tarefa de acordo com o Id fornecido
    public Task updateTask(
            long taskId, String title, String description, Date dueDate,
            boolean completed, ServiceContext serviceContext) throws PortalException {

        Task task = taskLocalService.getTask(taskId);

        if (Validator.isNull(task)) {
            throw new NoSuchTaskException("Task with taskId " + taskId + " not found");
        }

        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(completed);
        task.setModifiedDate(serviceContext.getModifiedDate(new Date()));

        return taskLocalService.updateTask(task);
    }
}
