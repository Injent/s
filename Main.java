package org.example;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final File fileStores = new File("D:\\IntellijIdeaProjects\\stat_grad1\\stores.csv");
    public static final File fileItemTypes = new File("D:\\IntellijIdeaProjects\\stat_grad1\\item.csv");
    public static final File fileTrading = new File("D:\\IntellijIdeaProjects\\stat_grad1\\trading.csv");

    public static void main(String[] args) {
        search("Центральный", "Мясная гастрономия", 7, 13, 6);
        search("Первомайский", "Бакалея", 14, 20, 6);
    }

    public static void search(String storeName, String itemType, int from, int to, int month) {
        var stores = new ArrayList<String>();
        var itemTypes = new ArrayList<String>();
        var sum = 0;

        try (var scanner = new Scanner(fileStores)) {
            while (scanner.hasNext()) {
                var fields = scanner.nextLine().split(";");
                if (fields[1].equalsIgnoreCase(storeName))
                    stores.add(fields[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (var scanner = new Scanner(fileItemTypes)) {
            while (scanner.hasNext()) {
                var fields = scanner.nextLine().split(";");
                if (fields[1].equalsIgnoreCase(itemType))
                    itemTypes.add(fields[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (var scanner = new Scanner(fileTrading)) {
            while (scanner.hasNext()) {
                var fields = scanner.nextLine().split(";");
                var store = fields[2];
                var type = fields[3];
                var operation = fields[4];
                var count = Integer.parseInt(fields[5]);
                var cost = Integer.parseInt(fields[6]);
                var date = LocalDate.parse(fields[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                if (!operation.equalsIgnoreCase("Продажа")) continue;
                if (!stores.contains(store)) continue;
                if (!itemTypes.contains(type)) continue;
                if ((date.getDayOfMonth() >= from && date.getDayOfMonth() <= to) && date.getMonthValue() == month) {
                    sum += cost * count;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Result 1: " + sum);
    }
}
