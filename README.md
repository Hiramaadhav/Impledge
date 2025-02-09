----------------------------------------------------------------------For Input_01.txt------------------------------------------------------------------------------


OVERVIEW

This program processes words from an input file to determine the longest and second-longest compounded words. A compounded word is one that can be formed using other words from the list. Additionally, the program measures the time taken to process another input file. The design leverages a HashSet for fast lookups and recursive checks for compound word validation.


EXECUTION STEPS:

1.Prepare Input Files:
-Ensure Input_01.txt contains a list of words, one per line.
-Ensure Input_02.txt is available for processing time measurement.

2.Compile the Java Program:
-javac Main.java

3.Run the Program:
-java Main

4.Expected Output:
-The longest compounded word: ratcatdogcat
-The second-longest compounded word: catsdogcats
-Time taken to process Input_02.txt: 500 ms


DESIGN AND DECISION APPROACH:

-Efficiency: A HashSet is used for quick word lookups.
-Sorting: Compound words are sorted by length in descending order.
-Performance Measurement: Processing time for Input_02.txt is measured using System.nanoTime().
-Recursive Approach: The function isCompound() checks if a word can be formed by combining other words in the list.


----------------------------------------------------------------------For Input_02.txt------------------------------------------------------------------------------


OVERVIEW

This program identifies the longest and second-longest compounded words from a given input file and measures the time taken to process the file. A compounded word is one that can be formed using other words from the input list. The program is efficient, leveraging HashSet for fast lookups and streams for concise processing.


EXECUTION STEPS:

1.Prepare Input File:
-Ensure Input_02.txt contains a list of words, one per line.

2.Compile the Java Program:
-javac Main.java

3.Run the Program:
-java Main

4.Expected Output:
-Longest compounded word: exampleword  
-Second longest compounded word: anotherword  
-Time taken to process Input_02.txt: 8000 ms  


DESIGN AND DECISION APPROACH:

-Efficient Data Storage: A HashSet is used to store words for O(1) lookup time.
-Compound Word Detection: A recursive approach checks if a word can be formed using smaller words from the set.
-Optimized Sorting: The compounded words are sorted by length in descending order.
-Performance Measurement: The program calculates the time taken to read and process the file using System.nanoTime().



This implementation ensures a balance between readability and performance while effectively solving the problem.
