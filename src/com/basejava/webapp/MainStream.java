package com.basejava.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    // Сhecking methods
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
        System.out.println("");

        List<Integer> result = oddOrEven(integers);
        for (Integer num : result) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        IntStream.range(0, SIZE)
                .forEach(index -> values[index] = random.nextInt(UPPER_BOUND));
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println("\n" + minValue(values));
    }

    // TODO: oddOrEven(List<Integer> integers)
    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream()
                .mapToInt(i -> i)
                .sum();
//        System.out.println(sum);
        if (sum % 2 != 0) {
            return integers.stream()
                    .filter(x -> x % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            return integers.stream()
                    .filter(x -> x % 2 != 0)
                    .collect(Collectors.toList());
        }
    }

    // TODO: minValue(int[] values)
    private static int minValue(int[] values) {
        int minValue = 0;
        int[] result = Arrays.stream(values)
                .filter(x -> (x > 0))
                .distinct()
                .sorted()
                .toArray();

        for (Integer num : result) {
            minValue = 10 * minValue + num;
        }
        return minValue;
    }
}
