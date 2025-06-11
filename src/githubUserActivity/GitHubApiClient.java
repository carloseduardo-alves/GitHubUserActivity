package githubUserActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GitHubApiClient {
	public static String fetchUserEvents(String username) throws Exception {
		String urlString = "https://api.github.com/users/" + username + "/events";
		URI uri = URI.create(urlString);
        URL url = uri.toURL(); //
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Java Github");
		
		int responseCode = connection.getResponseCode();
		
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(
				new InputStreamReader(connection.getInputStream())
			);
			String inputLine;
			StringBuilder response = new StringBuilder();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return response.toString();
		} else if (responseCode == 404) {
			throw new Exception("Usuário não encontrado.");
		} else {
			throw new Exception("Erro ao conectar à API: Código " + responseCode);
		}
	}
}
