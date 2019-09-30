import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        try {
            File file = new File("file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            HashMap<String, Integer> dictionary = new HashMap<>();
            while (line != null) {
                String[] splitted = line.split("\\s*([\\s,!.\\-?:;—\n…\t«»()\"'])\\s*");
                for(String word:splitted)
                    if (!word.equals(""))
                        if(dictionary.containsKey(word.toLowerCase()))
                            dictionary.put(word.toLowerCase(),dictionary.get(word.toLowerCase()) + 1);
                        else
                            dictionary.put(word.toLowerCase(),1);
                line = reader.readLine();
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(dictionary.entrySet());
            list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            for(int i=0; i<20; i++)
                System.out.println(list.get(i));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
