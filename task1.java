// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;

public class task1 {

  public static void main(String[] args) {
    HashMap<String, ArrayList<Integer>> items = new HashMap<String, ArrayList<Integer>>();
    addToList(items, "Sergey", 8457938);
    addToList(items, "Sergey", 4523542);
    addToList(items, "Alexey", 23432434);
    addToList(items, "Alexey", 234324545);
    System.out.println(items);
  }
  
  public static void addToList(HashMap<String, ArrayList<Integer>> uItems, String mapKey, Integer myItem) {
    ArrayList<Integer> itemsList = uItems.get(mapKey);
  
    // if list does not exist create it
    if(itemsList == null) {
         itemsList = new ArrayList<Integer>();
         itemsList.add(myItem);
         uItems.put(mapKey, itemsList);
    } else {
        // add if item is not already in list
        if(!itemsList.contains(myItem)) itemsList.add(myItem);
    }
  }
}