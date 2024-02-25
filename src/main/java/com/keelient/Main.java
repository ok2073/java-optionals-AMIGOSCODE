package com.keelient;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());
        System.out.println("---------------------------------------");
        Optional<Object> stringOpt = Optional.of("hello");
        System.out.println(stringOpt.isPresent()); //checks if object is != null
        System.out.println(stringOpt.isEmpty()); //checks if object is == null
        System.out.println("---------------------------------------");
        Object orElse = empty.orElse("world");
        System.out.println(orElse);
        System.out.println("---------------------------------------");
        //ofNullable means that the object may be null
        Optional<String> nullableObject = Optional.ofNullable(null);
        String objectIsNull = nullableObject.orElse("object is null");
        System.out.println(objectIsNull.isEmpty());
        System.out.println(objectIsNull);
        System.out.println("---------------------------------------");
        Optional<String> nullableObjectMap = Optional.of("Oliver Queen");
        String objectIsNullMap = nullableObjectMap
                                    .map(String::toUpperCase)
                                    .orElse("object is null");
        System.out.println(objectIsNullMap.isEmpty());
        System.out.println(objectIsNullMap);
        System.out.println("---------------------------------------");
        Optional<String> nullableObject2 = Optional.ofNullable(null);
        String objectIsNullMap2 = nullableObject
                .map(String::toUpperCase) // Map to uppercase if present
                .orElseGet(() -> {
                    // Generate a random number and return it as a string
                    int randomNumber = (int) (Math.random() * 100);
                    return "Generated number: " + randomNumber;
                });

        System.out.println(nullableObject2.isEmpty()); // Check if the original Optional was empty
        System.out.println(objectIsNullMap2);
        System.out.println("---------------------------------------");
        Optional<String> nullableObject3 = Optional.ofNullable(null);
        String objectIsNullMap3 = nullableObject3
                .map(String::toUpperCase) // Map to uppercase if present
                .orElse("inside orelse");
        System.out.println(nullableObject3.isEmpty()); // Check if the original Optional was empty
        System.out.println(objectIsNullMap3);
        /*System.out.println("---------------------------------------");
        Optional<String> nullableObject4 = Optional.ofNullable(null);
        String objectIsNullMap4 = nullableObject4
                .map(String::toUpperCase) // Map to uppercase if present
                .orElseThrow(() -> new IllegalStateException());
        System.out.println(nullableObject4.isEmpty()); // Check if the original Optional was empty
        System.out.println(objectIsNullMap4);*/
        System.out.println("---------------------------------------");
        Optional<String> nullableObject5 = Optional.of("Hi!");
        nullableObject5
                .ifPresent(x -> System.out.println("Hello world!"));
        System.out.println(nullableObject5.isEmpty());
        System.out.println("---------------------------------------");
        Optional<String> nullableObject6 = Optional.of("Hi!");
        nullableObject6
                .ifPresentOrElse(x -> System.out.println("IFPRESENT"),
                        () -> System.out.println("ORELSE"));
        System.out.println(nullableObject6.isEmpty());
        System.out.println("---------------------------------------");
        Person james = new Person("james", null);
        System.out.println(james.getEmail().map(String::toLowerCase).orElse("email not provided"));
        Person oliver = new Person("james", "OLIVER.QUEEN@STARCITY.COM");
        System.out.println(oliver.getEmail().map(String::toLowerCase).orElse("email not provided"));
        Person thea = new Person("james", null);
        System.out.println(thea.getEmail().orElse("email not provided"));
    }

    static class Person {
        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

    }

}