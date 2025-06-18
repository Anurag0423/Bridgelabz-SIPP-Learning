import java.util.*;

class RockPaperGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();

        String[][] results = new String[games][3];
        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            results[i][0] = userChoice;
            results[i][1] = computerChoice;
            results[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, games);
        displayResults(results, stats);
    }

    public static String getComputerChoice() {
        String[] options = {"rock", "paper", "scissors"};
        return options[(int) (Math.random() * 3)];
    }

    public static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("scissors") && comp.equals("paper")) ||
            (user.equals("paper") && comp.equals("rock"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int total) {
        String[][] stats = new String[3][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", (userWins * 100.0) / total) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / total) + "%";

        stats[2][0] = "Draw";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / total) + "%";

        return stats;
    }

    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("User\tComputer\tWinner");
        for (String[] row : results) {
            System.out.println(row[0] + "\t" + row[1] + "\t\t" + row[2]);
        }

        System.out.println("\nSummary:");
        System.out.println("Player\tWins\tWin Percentage");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }
}
