import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Nout nout1 = new Nout();
        nout1.brend = "Aser";
        nout1.ozu = 16;
        nout1.valueGD = 500;
        nout1.os = "Windows10";

        Nout nout2 = new Nout();
        nout2.brend = "HP";
        nout2.ozu = 32;
        nout2.valueGD = 1000;
        nout2.os = "Windows11";

        Nout nout3 = new Nout();
        nout3.brend = "Dell";
        nout3.ozu = 8;
        nout3.valueGD = 1500;
        nout3.os = "Windows7";

        Nout nout4 = new Nout();
        nout4.brend = "Lenovo";
        nout4.ozu = 16;
        nout4.valueGD = 250;
        nout4.os = "Linuks";

        Set<Nout> nouts = new HashSet<>();
        nouts.add(nout1);
        nouts.add(nout2);
        nouts.add(nout3);
        nouts.add(nout4);


        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерии для фильтрации:");
        System.out.println("1 - Бренд");  
        System.out.println("2 - Объем Опративной памяти");  
        System.out.println("3 - Объем жесткого диска"); 
        System.out.println("4 - Операционная система");    
        System.out.println("0 - Завершить выбор");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Выбе3рите Брэнд: Aser, HP, Dell, Lenovo");
                    filters.put("brend", scanner.next());
                    System.out.println("Выберите критерии для фильтрации, или завершите выбор - 0");
                    break;                    
                case 2:
                    System.out.println("Выберите минимальный объем оперативной памяти: 8,16,32");
                    filters.put("ozu", scanner.nextInt());
                    System.out.println("Выберите критерии для фильтрации, или завершите выбор - 0");
                    break;
                case 3:
                    System.out.println("Выберите объем жесткого диска: 250,500,1000,1500");
                    filters.put("valueGD", scanner.nextInt());
                    System.out.println("Выберите критерии для фильтрации, или завершите выбор - 0");
                    break;
                case 4:
                    System.out.println("Выберите операционную систему: Windows7, Windows10, Windows11, Linuks");
                    filters.put("os", scanner.next());
                    System.out.println("Выберите критерии для фильтрации, или завершите выбор - 0");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        Set<Nout> filteredNouts = nouts.stream()
                .filter(nout -> filters.getOrDefault("brend", "").equals("") || nout.brend.equalsIgnoreCase((String) filters.getOrDefault("brend", "")))
                .filter(nout -> filters.getOrDefault("ozu", 0) instanceof Integer && nout.ozu >= (int) filters.getOrDefault("ozu", 0))
                .filter(nout -> filters.getOrDefault("valueGD", 0 ) instanceof Integer && nout.valueGD >= (int) filters.getOrDefault("valueGD", 0))
                .filter(nout -> filters.getOrDefault("os", "").equals("") || nout.os.equalsIgnoreCase((String) filters.getOrDefault("os", "")))
                .collect(Collectors.toSet());

        System.out.println("Отфильтрованные ноутбуки:");
        for (Nout nout : filteredNouts) {
            System.out.println(nout);
        }




    //     printSet(filterAsOzu(nouts, 8));

    // }
    // static Set<Nout> filterAsOzu(Set<Nout> nouts, int ozu){
    //     Set<Nout> set = new HashSet<>();
    //     for (Nout nout: nouts){
    //         if (nout.ozu == ozu){
    //             set.add(nout);
    //         }

    //     }
    //     return set;

    // }
    // static void printSet(Set<Nout> set){
    //     for (Nout nout: set){
    //         System.out.println(nout);
    //     }
    }
}
