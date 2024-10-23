package ru.geekbrains.lesson1.task3;


/*

Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

       IntSummaryStatistics chet = list.stream().filter(n -> n % 2 == 0).collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(chet.getAverage());

    }


}
