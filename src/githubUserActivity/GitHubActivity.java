package githubUserActivity;

public class GitHubActivity {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Uso: java GitHubActivity <username>");
            return;
		}
		
		String username = args[0];
		
		try {
			String json = GitHubApiClient.fetchUserEvents(username);
			
			GitHubEventParser.printUserActivity(json);
		} catch (Exception e) {
            System.out.println("Erro ao buscar atividades: " + e.getMessage());
        }
	}
}
