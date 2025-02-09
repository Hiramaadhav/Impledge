import java.io.*;
import java.util.*;

public class Main {
    static Set<String> wordsSet = new HashSet<>();
    static List<String> compoundWords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        loadWords("Input_02.txt");
        findCompoundWords();
        printResults();
        measureProcessingTime("Input_02.txt");
    }
    private static void loadWords(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.lines().forEach(line -> wordsSet.add(line.trim()));
        }
    } 
    private static void findCompoundWords() {
        wordsSet.stream().filter(word -> isCompound(word, true)).forEach(compoundWords::add);
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
        System.out.println("Time taken to process " + filename + ": " + (System.nanoTime() - startTime) / 1_000_000 + " ms");
    }
    private static boolean isCompound(String word, boolean isOriginalWord) {
        if (!isOriginalWord && wordsSet.contains(word)) return true;
        return IntStream.range(1, word.length()).anyMatch(i -> wordsSet.contains(word.substring(0, i)) && isCompound(word.substring(i), false));
    }
}

