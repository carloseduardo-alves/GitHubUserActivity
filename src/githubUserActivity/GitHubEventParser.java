package githubUserActivity;

public class GitHubEventParser {
	public static void printUserActivity(String json) {
		if (json == null || json.isEmpty()) {
			System.out.println("Nenhuma atividade encontrada.");
            return;
		}
		
		String[] events = json.split("\\},\\{");
		
		System.out.println("Atividades recentes:");
		
		for (String event : events) {
            String type = extractField(event, "\"type\":\"", "\"");
            String repo = extractField(event, "\"repo\":\\{\"id\":[^,]*,\"name\":\"", "\"");

            switch (type) {
                case "PushEvent":
                    System.out.println("- Fez push para " + repo);
                    break;
                case "WatchEvent":
                    System.out.println("- Deu estrela em " + repo);
                    break;
                case "IssuesEvent":
                    System.out.println("- Interagiu com uma issue em " + repo);
                    break;
                case "ForkEvent":
                    System.out.println("- Fez fork de " + repo);
                    break;
                case "PullRequestEvent":
                    System.out.println("- Criou/alterou um Pull Request em " + repo);
                    break;
                default:
                    System.out.println("- " + type + " em " + repo);
            }
        }
    }

    private static String extractField(String text, String start, String end) {
        int startIndex = text.indexOf(start);
        if (startIndex == -1) return "desconhecido";

        startIndex += start.length();
        int endIndex = text.indexOf(end, startIndex);
        if (endIndex == -1) return "desconhecido";

        return text.substring(startIndex, endIndex);
    }
}
