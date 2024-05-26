package gx2.com.br.portlet;

import gx2.com.br.constants.VitorDesafioPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author user
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=VitorDesafio",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VitorDesafioPortletKeys.VITORDESAFIO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VitorDesafioPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ZoneId zoneId = ZoneId.of("America/Sao_Paulo"); // Default Time: Brasília
		String userZone = renderRequest.getParameter("userZone");
		if (userZone != null && !userZone.isEmpty()) {
			zoneId = ZoneId.of(userZone);
		}

		ZonedDateTime dateTime = ZonedDateTime.now(zoneId);
		String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

		renderRequest.setAttribute("currentTime", formattedDateTime);
		super.doView(renderRequest, renderResponse);
	}
}