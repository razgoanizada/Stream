import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //e1

        Person roni = new Person("Roni", 81);
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 13);
        Person michal = new Person("Michal", 42);
        List<Person> collection = Arrays.asList(sara, viktor, roni ,michal);
        getKidNames(collection).forEach(System.out::println);


        //e2

        Person Roni = new Person("Roni", 81, "Israel");
        Person Sara = new Person("Sara", 4, "USA");
        Person Viktor = new Person("Viktor", 13, "Israel");
        Person Michal = new Person("Michal", 42, "Israel");
        List<Person> collectionE2 = Arrays.asList(Sara, Viktor, Roni ,Michal);
        groupByCountry(collectionE2);


        //e3

        System.out.println(getIntegerString(Arrays.asList(4,5,9,12,14)));


    }


    public static Set<String> getKidNames(List<Person> people){


        Set<String> kids = people.stream()
                .filter(person -> person.getAge() < 18)
                .map(person -> person.getName())
                .collect(Collectors.toSet());

      return kids;

    }


    public static void groupByCountry(List<Person> people){

        Map<String, Person> sortCountry = people.stream()
                .collect(Collectors.toMap(
                        person -> person.getName(),
                        person -> person,
                        ((person, person2) -> person.getAge() >= person2.getAge() ? person : person2)
                        ));

        Map<String, List<Person>> map = sortCountry.values().stream()
                .collect(Collectors.groupingBy(Person :: getCountry
                ));

        for (String key : map.keySet())
            System.out.println("Key : " + key + " Value : " + map.get(key));

    }


    public static String getIntegerString(List<Integer> list) {

        List<String> numbers = list.stream()
                .map(number -> number % 2 == 1 ? "e" + number : "o" + number)
                .collect(Collectors.toList());

       return numbers.toString();


    }
}