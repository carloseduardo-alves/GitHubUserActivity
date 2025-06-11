# GitHub User Activity CLI (Java)

GitHub User Activity is a simple Command Line Interface (CLI) application built in Java to fetch and display recent activity from any GitHub user. It helps you practice API integration, JSON handling, and building terminal-based Java apps using only core Java libraries.

### Requirements
Before running this project, make sure you have the following tools installed:
- **Java JDK 17+** – required to compile and run the application
- **Git** – to clone the repository (optional, can also download manually)
- **IDE**: Eclipse, IntelliJ IDEA or VSCode with Java Extension Pack.
- **No external libraries required** – all logic built using Java standard classes.

### Technologies Used
- Java (JDK 17 or later recommended)
- `HttpURLConnection` – to make HTTP requests to the GitHub API
- `BufferedReader`, `InputStreamReader` – to read the API responses
- Manual string manipulation – for lightweight JSON parsing
- No external frameworks or libraries used

### Features
- Accepts GitHub username as CLI argument
- Fetches recent public activity using the GitHub Events API
- Displays actions like:
  - Pushed commits
  - Starred repositories
  - Opened issues
  - Forked projects
  - Created pull requests
- Handles invalid usernames and API errors gracefully

### How to Install and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/carloseduardo-alves/GitHubUserActivity.git
   cd GitHubUserActivity
   ```

2. Open the project in your IDE (e.g., Eclipse)

3. Compile and run the app:
   ```bash
   javac GitHubActivity.java GitHubApiClient.java GitHubEventParser.java
   java GitHubActivity <github-username>
   ```

4. The application will print recent activities in the terminal:
   ```
   Recent activities:
   - Pushed to kamranahmedse/developer-roadmap
   - Starred kamranahmedse/developer-roadmap
   - Opened an issue in kamranahmedse/developer-roadmap
   ```

### How It Works
- `GitHubActivity.java`: Main entry point; handles argument and calls client/parser
- `GitHubApiClient.java`: Makes a GET request to `https://api.github.com/users/<username>/events`
- `GitHubEventParser.java`: Extracts event type and repository from the JSON manually

### What I Learned
- How to perform HTTP GET requests in Java
- Reading and parsing JSON without external libraries
- Handling errors like bad requests and empty responses
- Building a clean, modular CLI project in Java
- Better understanding of how GitHub’s API works

## Acknowledgements
This project idea was inspired by the GitHub User Activity challenge from [roadmap.sh](https://roadmap.sh/projects/github-user-activity). An excellent source of practical, real-world coding exercises.


## License
This project is licensed under the MIT License.
