package assignments;

import java.util.*;

public class LiveCodingSession {

    // --- Problem 1: Rock-Paper-Scissors Game ---
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void runRpsGame() {
        System.out.println("=== Problem 1: Rock-Paper-Scissors Game ===");
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;
        int totalRounds = 5;

        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String pMove = playerMoves[i % playerMoves.length];
            String cMove = moves[random.nextInt(moves.length)];
            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("%-8d | %-12s | %-14s | %-14s%n", (i + 1), pMove, cMove, result);
        }

        double winPct = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n%n",
                wins, losses, draws, winPct);
    }

    // --- Problem 2: Palindrome Checker (3 Approaches) ---
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return Arrays.equals(chars, reversed);
    }

    public static void runPalindromeChecks() {
        System.out.println("=== Problem 2: Palindrome Checker ===");
        String[] testWords = {"madam", "hello"};

        for (String word : testWords) {
            boolean iter = isPalindromeIterative(word);
            boolean recur = isPalindromeRecursive(word);
            boolean rev = isPalindromeArrayReversal(word);

            System.out.printf("Input: \"%s\"%n", word);
            System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                    iter ? "Palindrome" : "Not Palindrome",
                    recur ? "Palindrome" : "Not Palindrome",
                    rev ? "Palindrome" : "Not Palindrome");
        }
    }

    // --- Problem 3: BMI Calculator for a Team ---
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("=== Problem 3: BMI Calculator for a Team ===");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println();
    }

    // --- Problem 4: First Non-Repeating Character ---
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freqMap.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void runNonRepeatingCharDemo() {
        System.out.println("=== Problem 4: First Non-Repeating Character ===");
        String[] samples = {"swiss", "aabbcc"};

        for (String sample : samples) {
            char result = findFirstNonRepeatingChar(sample);
            if (result != '\0') {
                System.out.printf("Input: \"%s\" -> First Non-Repeating Character: '%c'%n", sample, result);
            } else {
                System.out.printf("Input: \"%s\" -> No Non-Repeating Character Found%n", sample);
            }
        }
        System.out.println();
    }

    // --- Problem 5: Reverse Customer Name ---
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void runReverseNameDemo() {
        System.out.println("=== Problem 5: Reverse Customer Name ===");
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }

    // --- Main Method ---
    public static void main(String[] args) {
        runRpsGame();
        runPalindromeChecks();

        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.85, 1.55, 1.72, 1.68, 1.78};
        double[] weights = {70.0, 90.0, 65.0, 80.0, 50.0, 95.0, 48.0, 75.0, 62.0, 85.0};
        printWellnessReport(heights, weights);

        runNonRepeatingCharDemo();
        runReverseNameDemo();
    }
}