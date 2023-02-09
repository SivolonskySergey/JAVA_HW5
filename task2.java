import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class task2 {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("names.txt");
    Scanner scanner = new Scanner(path);
    String line = "";
    while (scanner.hasNextLine()) {
      line += scanner.nextLine() + ",";
    }
    scanner.close();
    String[] names = line.split(",");

    ArrayList<String> pplList = new ArrayList<String>();
    for (int i = 0; i < names.length; i++) {
      pplList.add(names[i]);
    }

    HashMap<String, Integer> mapNames = new HashMap<>();
    for (int i = 0; i < pplList.size(); i++) {
      String strToAdd = pplList.get(i).split(" ")[0];
      if (!mapNames.containsKey(strToAdd)) {
        mapNames.put(strToAdd, 1);
      }
      mapNames.put(strToAdd, mapNames.get(strToAdd) + 1);
    }

    List<Integer> namesCount = new ArrayList<Integer>(mapNames.values());
    namesCount.sort(Collections.reverseOrder());

    HashMap<String, Integer> finalList = new LinkedHashMap<String, Integer>();
    for (int counter : namesCount) {
      for (String pplName : mapNames.keySet()) {
        if (counter == mapNames.get(pplName)) {
          finalList.put(pplName, counter);
        }
      }
    }
    System.out.println(finalList);
  }
}
