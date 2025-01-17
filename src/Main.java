import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        TreeMap<String,String> telephoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        for (;;){
            String command = scanner.nextLine();
            if (command.equals("LIST")) {
                listContains(telephoneBook);
                continue;
            }
            if (command.matches("\\d+")){
                if (check(telephoneBook,command)) System.out.println(checkAdd(telephoneBook,command));
                else {
                    System.out.println("Введите имя");
                    String name = scanner.nextLine();
                    telephoneBook.put(name,command);
                }
            }
            else {
                if (telephoneBook.containsKey(command)) System.out.println(telephoneBook.get(command));
                else {
                    System.out.println("Введите номер");
                    String number = scanner.nextLine();
                    telephoneBook.put(command,number);
                }
            }

        }

    }

    private static void listContains(Map<String, String> telephoneBook){
        for (String contact : telephoneBook.keySet()) System.out.println(contact + " " + telephoneBook.get(contact));
    }
    private  static boolean check(Map<String, String> telephoneBook, String number){
        for (String contact : telephoneBook.keySet()) {
            if (telephoneBook.get(contact).equals(number)) return true;
            }
        return false;
    }
    private  static String checkAdd(Map<String, String> telephoneBook, String number){
        for (String contact : telephoneBook.keySet()) {
            if (telephoneBook.get(contact).equals(number)) return contact;
        }
        return "";
    }


}

