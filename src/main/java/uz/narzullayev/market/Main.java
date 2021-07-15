package uz.narzullayev.market;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("N o'lchamni kiriting:");
        Map<Integer,Integer> treeMap=new TreeMap<>();
        IntStream.rangeClosed(0,scanner.nextInt()).parallel().forEach(value -> {
            System.out.println(value);
        });



    }
}
