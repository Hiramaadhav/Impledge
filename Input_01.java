import java.io.*;
import java.util.*;

public class Main {
    static Set<String> wordsSet = new HashSet<>();
    static List<String> compoundWords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        loadWords("Input_01.txt");
        findCompoundWords();
        printResults();
        measureProcessingTime("Input_02.txt");
    }
    private static void loadWords(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordsSet.add(line.trim());
            }
        }
    } 
    private static void findCompoundWords() {
        for (String word : wordsSet) {
            if (isCompound(word, true)) {
                compoundWords.add(word);
            }
        }
        compoundWords.sort(Comparator.comparingInt(String::length).reversed());
    } 
    private static void printResults() {
        System.out.println("Longest compounded word: " + (compoundWords.isEmpty() ? "None" : compoundWords.get(0)));
        System.out.println("Second longest compounded word: " + (compoundWords.size() > 1 ? compoundWords.get(1) : "None"));
    }
    private static void measureProcessingTime(String filename) throws IOException {
        long startTime = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null) {}
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken to process " + filename + ": " + (endTime - startTime) / 1_000_000 + " ms");
    }
    private static boolean isCompound(String word, boolean isOriginalWord) {
        if (!isOriginalWord && wordsSet.contains(word)) return true;
        for (int i = 1; i < word.length(); i++) {
            if (wordsSet.contains(word.substring(0, i)) && isCompound(word.substring(i), false)) {
                return true;
            }
        }
        return false;
    }
}
