package com.basejava.webapp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    // Checking methods
    public static final int SIZE = 10;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        int[] values = new int[SIZE];
        Random random = new Random();

        IntStream.range(0, SIZE)
                .forEach(index -> integers.add(random.nextInt(UPPER_BOUND)));
        for (Integer num : integers) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<Integer> result = oddOrEven(integers);
        for (Integer num : result) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        IntStream.range(0, SIZE)
                .forEach(index -> values[index] = random.nextInt(UPPER_BOUND));
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println("\n" + minValue(values));
    }

    // TODO: oddOrEven(List<Integer> integers)
    private static List<Integer> oddOrEven(List<Integer> integers) {
        final Map<Boolean, List<Integer>> map = integers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 != 0));

        return map.get(true).size() % 2 != 0 ? map.get(false) : map.get(true);
        /*
         порядок выполнения:
         1. partitioningBy(x -> x % 2 != 0) - разделение на две мапы с ключами isOdd = true, !isOdd = false;
         2. map.get(true) - получение списка нечетных элементов, size() - получение количества элементов списка нечетных чисел,
         тернарный оператор: % 2 != 0 ? map.get(false) : map.get(true) - если количество элементов в списке нечетных чисел нечетное,
         то вернуть список четных чисел, иначе вернуть список нечетных чисел.
         */
    }

    // TODO: minValue(int[] values)
    private static int minValue(int[] values) {
        return Arrays.stream(values)
                .filter(x -> (x > 0))
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> 10 * a + b);
    }
}
