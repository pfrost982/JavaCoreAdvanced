package lesson1;

public class Main {
    final static int OBSTACLESNUM = 5;
    final static int PARTICIPANTSNUM = 5;

    public static void main(String[] args) {
        Obstacle[] obstacles = new Obstacle[OBSTACLESNUM];
        createObstacles(obstacles);
        System.out.println("Препятствия:");
        for (Obstacle obstacle : obstacles) {
            System.out.println(obstacle);
        }

        Participant[] participants = new Participant[PARTICIPANTSNUM];
        createParticipants(participants);
        System.out.println("\nУчастники:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }

        System.out.println("\nНачинаем испытания:");
        for (Participant participant : participants) {
            System.out.println();
            personalChallenge(participant, obstacles);
        }
    }

    public static void createObstacles(Obstacle[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                obstacles[i] = new Wall(Math.random());
            } else {
                obstacles[i] = new Track((int) (Math.random() * 100 + 51));
            }
        }
    }

    private static void createParticipants(Participant[] participants) {
        String[] names = {"Макс", "Бейли", "Чарли", "Бадди", "Рокки", "Джейк", "Джек", "Тоби", "Коди", "Бустер", "Герцог",
                "Купер", "Райли", "Харлей", "Биар", "Такер", "Мерфи", "Лаки", "Оливер", "Сэм", "Оскар", "Тедди",
                "Уинстон", "Сэмми", "Шэдоу", "Гизмо", "Бэнтли", "Зевс", "Джексон", "Бакстер", "Бандит", "Гас",
                "Самсон", "Мило", "Руди", "Луи", "Хантер", "Кейси", "Рокко", "Спаркли", "Джоуи", "Бруно", "Бо",
                "Дакота", "Максимус", "Ромео", "Бумер", "Люк", "Генри"};
        for (int i = 0; i < participants.length; i++) {
            int random = (int) (Math.random() * 3);
            if (random == 0) {
                participants[i] = new Cat(names[(int) (Math.random() * names.length)], (int) (Math.random() * 50) + 101, Math.random() * 0.5 + 0.6);
            } else if (random == 1) {
                participants[i] = new Man(names[(int) (Math.random() * names.length)], (int) (Math.random() * 50) + 101, Math.random() * 0.5 + 0.6);
            } else {
                participants[i] = new Robot(names[(int) (Math.random() * names.length)], (int) (Math.random() * 50) + 101, Math.random() * 0.5 + 0.6);
            }
        }
    }

    private static void personalChallenge(Participant participant, Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            boolean overcome = obstacle.overcome(participant);
            if (!overcome) break;
        }
    }
}
