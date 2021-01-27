package com.home.takeaway;

import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TakeawayApplicationTests {

    @Test
    public void studying_some_futures() throws FileNotFoundException {
        String a = "ab";
        String b = "ab";
        long value = 1;
        HashMap<Long, String> map = new HashMap<>();
        map.put(value,"asd");
        LinkedList<String> stringList = new LinkedList<>(Arrays.asList("a1", "a2", "a3", "a4", "a5"));

        repeatedArrayValue(100, 88);
        int[] array = {1,4,9,3,6,8,4,6,7,2,5,0};
        boobleSorting(array);
        System.out.println(checkBrackets("()"));
    }

    private boolean checkBrackets(String str) {
        Stack<Character> characterStack = new Stack<>();
        for (char current : str.toCharArray()) {
            if (current == '{' || current == '(' || current == '[')
                characterStack.push(current);
            if (current == '}' || current == ')' || current == ']') {
                if (characterStack.isEmpty()) return false;
                char last = characterStack.peek();
                if (last == '{' && current == '}' || last == '(' && current == ')'
                        || last == '[' && current == ']')
                    characterStack.pop();
                else return false;
            }
        }

        return characterStack.isEmpty();
    }

    private boolean checkBrackets2(String str) {
        if (str == null || str.isEmpty()) return true;

        while (str.contains("()") || str.contains("{}") || str.contains("[]")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\{\\}", "")
                    .replaceAll("\\[\\]", "");
        }
        return str.isEmpty();
    }

    private String printPrimeNumber(int maxNumber) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= maxNumber; i++) {
            if (isPrime(i))
                result.append(i + " ");
        }
        return result.toString();
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if ((number % i) == 0)
                return false;
        }
        return true;
    }

    private int factorial(int number) {
        if (number == 0)
            return 1;
        return number * factorial(number-1);
    }

    private String repeatedArrayValue(int max, int index) {
        int[] array = IntStream.range(1, max+1).toArray();
        array[index] = 43;


        int distincsSum = Arrays.stream(array).distinct().sum();
        int totalSum = Arrays.stream(array).sum();
        int repIndex = totalSum - distincsSum;
        return String.format("Value: %s", array[repIndex]);
    }

    private void boobleSorting(int[] array) {
        for (int i = array.length-1; i>0;i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

}