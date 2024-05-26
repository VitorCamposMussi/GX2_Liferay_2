package gx2.com.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.WebKeys;
import gx2.com.constants.hourUtcPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author user
 */
@Component(
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=hourUtc",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + hourUtcPortletKeys.HOURUTC,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class hourUtcPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUser(userId);

			String timeZoneId = user.getTimeZoneId();
			if (timeZoneId == null || timeZoneId.isEmpty()) {
				timeZoneId = TimeZoneUtil.getDefault().getID();
			}

			TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
			ZoneId zoneId = timeZone.toZoneId();
			ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zoneId);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");

			renderRequest.setAttribute("timeZoneId", timeZoneId);
			renderRequest.setAttribute("currentDateTime", zonedDateTime.format(formatter));

		} catch (PortalException e) {
			throw new PortletException(e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}
}