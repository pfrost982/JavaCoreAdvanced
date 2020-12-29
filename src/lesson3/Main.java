package lesson3;

import java.util.*;

public class Main {
    public static final int INITIALCAPACITY = 50;

    public static void main(String[] args) {
        String[] words = {"брови", "плотина", "троль", "сталь", "пирог", "овод", "понедельник", "рога", "абонемент",
                "гиря", "танец", "крыльцо", "север", "куст", "мишень", "племя", "коза", "вершины", "форма", "груша"};

        ArrayList<String> wordsList = new ArrayList<>(INITIALCAPACITY);
        for (int i = 0; i < INITIALCAPACITY; i++) {
            wordsList.add(words[(int) (Math.random() * words.length)]);
        }

        Set<String> wordsSet = new HashSet<>(wordsList);
        System.out.println(wordsSet + "\n");

        for (String uniqueWord : wordsSet) {
            int entryCount = 0;
            for (String word : wordsList) {
                if (uniqueWord.equals(word)) {
                    entryCount++;
                }
            }
            System.out.println(uniqueWord + ": " + entryCount);
        }
        System.out.println();

        String[] surnames = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Михайлов",
                "Новиков", "Фёдоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семёнов", "Егоров", "Павлов",
                "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров"};

        PhoneBook phoneBook = new PhoneBook(INITIALCAPACITY);
        for (int i = 0; i < INITIALCAPACITY; i++) {
            phoneBook.add(surnames[(int) (Math.random() * surnames.length)],
                    "+7913" + (int) (Math.random() * 9000000 + 1000000));
        }

        HashSet<String> phoneNumbers;
        for (String surname : surnames) {
            phoneNumbers = phoneBook.get(surname);
            if (phoneNumbers != null) {
                System.out.println(surname + ": " + phoneNumbers);
            }
        }
    }
}
