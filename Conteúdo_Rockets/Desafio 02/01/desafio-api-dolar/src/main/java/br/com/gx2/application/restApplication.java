package br.com.gx2.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
		immediate = true,
		property = {
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
		},
		service = Application.class
)
public class restApplication extends Application {

	private static final String ACCESS_KEY = "3b75451d2811cbd4b8c1f0bc16a2558e"; // sua access key

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/dollarRate")
	@Produces("application/json")
	public Response getDollarRate() {
		return getDollarRateForCurrency("BRL");
	}

	@GET
	@Path("/dollarRate/{currency}")
	@Produces("application/json")
	public Response getDollarRateForCurrency(@PathParam("currency") String currency) {
		String urlString = "http://api.currencylayer.com/live?access_key=" + ACCESS_KEY + "&currencies=" + currency + "&source=USD&format=1";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			// Limpar as conexões
			in.close();
			conn.disconnect();

			// Criar um JSONObject para processar a resposta
			JSONObject json = new JSONObject(content.toString());

			// Verifica se a resposta foi bem sucedida e contém a cotação
			if (json.getBoolean("success")) {
				double dollarToCurrency = json.getJSONObject("quotes").getDouble("USD" + currency);
				return Response.ok("{\"USD_" + currency + "\": " + dollarToCurrency + "}").build();
			} else {
				return Response.status(500).entity("Error fetching exchange rate: " + json.getString("error")).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Error occurred: " + e.getMessage()).build();
		}
	}
}
