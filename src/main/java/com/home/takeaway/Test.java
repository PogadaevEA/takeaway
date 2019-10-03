package com.home.takeaway;


import com.google.common.collect.Lists;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.ManyToOne;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Egor Pogadaev
 */
public class Test {

    private String some = ";";

    public static void main(String[] args) {
        int[] unsorted = {32, 39,21, 45, 23, 3};
        List<Integer> some = IntStream.of(unsorted).boxed().collect(Collectors.toList());
//        bubbleSort(unsorted);
        Integer[] wer = {1,2,3,4,5,6,6};
        int sum = Stream.of(wer).mapToInt(e ->e).sum() - Stream.of(wer).distinct().mapToInt(e ->e).sum();
        List<Integer> list1 = IntStream.range(1,100).boxed().collect(Collectors.toList());
        list1.set(53,23);
        System.out.println(list1.stream().mapToInt(e ->e).sum() - list1.stream().distinct().mapToInt(e ->e).sum());
        insertSort(unsorted);

        List <Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        elements.set(97, 23);
        elements.set(27, 51);
        elements.set(99, 23);

        Map<Integer,Integer> duplicates = new HashMap<>();
        elements.forEach(e -> duplicates.put(e, duplicates.get(e) == null ? 1 : duplicates.get(e) + 1 ));
        duplicates.entrySet().stream().filter(e -> e.getValue()>1).forEach(e -> System.out.println(String.format("Значение %d встречается %d раз", e.getKey(),e.getValue())));

        String value = "new String";
        IntStream str = value.chars();
        String res = str.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        List<People> peoples = Arrays.asList( new People("Вася",16, Sex.MAN), new People("Петя", 23, Sex.MAN), new People("Елена", 42, Sex.WOMEN), new People("Иван Иванович", 69, Sex.MAN));

        List<People> collect = peoples.stream().filter(p -> p.getAge()>=18 && p.getAge() <=27 && p.getSex() == Sex.MAN).collect(Collectors.toList());
        Double average = peoples.stream().filter(people -> people.getSex() == Sex.MAN).mapToInt(People::getAge).average().getAsDouble();
        System.out.println(peoples);

        List<String> col1 = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> col2 = Arrays.asList("1,2,0","4,5");

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        System.out.println("FINAL");
        A a = new A();
        a.pr();
        a = new B();
        a.pr();


    }

    private static void bubbleSort(int[] array) {
        System.out.println("Before: " + Arrays.toString(array));
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i< array.length-1;i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        System.out.println("Before: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j>=0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        System.out.println("After: " + Arrays.toString(array));
    }

    private static void copy(File fileFrom, File fileTo) throws IOException {
        try(InputStream inputStream = new FileInputStream(fileFrom);
            OutputStream outputStream = new FileOutputStream(fileTo))
        {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer,0,length);
            }
        }
    }

    private static void copyFiles(File fileFrom, File fileTo) throws IOException {
        Files.copy(fileFrom.toPath(), fileTo.toPath());
    }

    private static String  readFiles(String pathToFile) throws IOException {
        String result;
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        result = builder.deleteCharAt(builder.length()-1).toString();

        // если с кодировкой

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile), "windows-1251"));

        //или короче
        result = String.join(System.getProperty("line.separator"), Files.readAllLines(Paths.get(pathToFile)));
        //или еще короче
        return new String(Files.readAllBytes(Paths.get(pathToFile)));

    }
}
@AllArgsConstructor
class Com implements Comparable {

    private String value;
    @Override
    public int compareTo(Object o) {
        Com com = (Com) o;
        return this.value.compareTo(com.value);
    }
}

@AllArgsConstructor
@Data
class People {
    private String name;
    private Integer age;
    private Sex sex;


}

enum Sex {
    MAN,
    WOMEN
}

class A {
    public void pr(){
        System.out.println("THIS IS A");
    }
}

class B extends A {

    public void pr(){
        System.out.println("THIS IS B");
    }
}






