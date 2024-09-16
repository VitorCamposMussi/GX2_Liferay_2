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

/**
 * @author vitor.mussi
 */
@Component(
	immediate = true, // Adicionado para garantir ativação imediata

	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class restApplication extends Application {

	private static final String ACCESS_KEY = "193075c54213135d95e2bdb2dbff6e58"; // sua access key

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

//	@GET
//	@Produces("text/plain")
//	public String working() {
//		return "It works!";
//	}
//
//	@GET
//	@Path("/morning")
//	@Produces("text/plain")
//	public String hello() {
//		return "Good morning!";
//	}
//
//	@GET
//	@Path("/morning/{name}")
//	@Produces("text/plain")
//	public String morning(
//		@PathParam("name") String name,
//		@QueryParam("drink") String drink) {
//
//		String greeting = "Good Morning " + name;
//
//		if (drink != null) {
//			greeting += ". Would you like some " + drink + "?";
//		}
//
//		return greeting;
//	}

	@GET
	@Path("/dollarRate")
	@Produces("application/json")
	public Response getDollarRate() {
		String urlString = "http://api.currencylayer.com/live?access_key=" + ACCESS_KEY + "&currencies=BRL&source=USD&format=1";
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
				double dollarToBrl = json.getJSONObject("quotes").getDouble("USDBRL");
				return Response.ok("{\"USD_BRL\": " + dollarToBrl + "}").build();
			} else {
				return Response.status(500).entity("Error fetching exchange rate").build();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Error occurred: " + e.getMessage()).build();
		}
	}

}