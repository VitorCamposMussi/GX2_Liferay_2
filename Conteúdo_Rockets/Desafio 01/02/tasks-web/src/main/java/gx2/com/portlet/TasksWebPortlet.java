package gx2.com.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import gx2.com.constants.TasksWebPortletKeys;

import tasks.model.Task;
import tasks.service.TaskLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;


/**
 * @author user
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TasksWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TasksWebPortletKeys.TASKSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TasksWebPortlet extends MVCPortlet {
	@Reference
	private TaskLocalService _taskLocalService;

	public void addTask(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
		String title = ParamUtil.getString(actionRequest, "title");
		String description = ParamUtil.getString(actionRequest, "description");

		_taskLocalService.addTask(title, description);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<Task> tasks = _taskLocalService.getTasks();
		renderRequest.setAttribute("tasks", tasks);
		super.doView(renderRequest, renderResponse);
	}
}