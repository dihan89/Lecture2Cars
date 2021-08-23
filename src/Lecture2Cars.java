import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Lecture2Cars 
{
    public static void printResult(Map<String, Set<String>> typeToModels) {
        for (Map.Entry<String, Set<String>> entry : typeToModels.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for(String model : entry.getValue()) {
                System.out.println("\t" + model);
            }
            System.out.println();
        }
    }



    public static void main(String[] args) throws IOException {
        final String inputFileName = "D:\\cars.txt";
        Map<String, Set<String>> typeToModels = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String str;            
            while ((str = reader.readLine()) != null){
                String[] words = str.split(" ");
                if (typeToModels.containsKey(words[1])) {
                    typeToModels.get(words[1]).add(words[0]);
                } else {
                    Set<String> modelsSet = new HashSet<String>(){{
                        add(words[0]);
                    }};                
                    typeToModels.put(words[1], modelsSet);    
                }
            }
            printResult(typeToModels);
        }
    }
}