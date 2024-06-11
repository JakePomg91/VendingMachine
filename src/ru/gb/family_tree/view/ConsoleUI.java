package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        work = true;
    }


    @Override
    public void start() {
        while (work) {
            System.out.println(mainMenu.menu());
            int choice = getChoice();
            mainMenu.execute(choice);
        }
    }


    public void addHuman() {
        String name = getName();
        Gender gender = getGender();
        LocalDate birthDate = getBirthDate();
        getFamilyTreeInfo();
        int fatherID = getFatherID();
        int motherID = getMotherID();

        presenter.addHuman(name, gender, birthDate, fatherID, motherID);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        printAnswer(presenter.getFamilyTreeInfo());
    }

    public void sortByID() {
        presenter.sortByID();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByChildrenCount() {
        presenter.sortByChildrenCount();
        getFamilyTreeInfo();
    }

    public void findByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        printAnswer(presenter.findByName(name));
    }

    public void finish() {
        work = false;
        System.out.println("До свидания!");
    }


    private int getChoice() {
        String choiceStr = scanner.nextLine();
        int choice;
        try {
            choice = Integer.parseInt(choiceStr);
            if (choice <= mainMenu.size() && choice > 0) {
                return choice;
            } else {
                System.out.println("Введите число в диапозоне от 1-" + mainMenu.size());
                choice = getChoice();
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите число!");
            choice = getChoice();
        }
        return choice;
    }

    private int getMotherID() {
        System.out.println("Введите ID матери (в случае отсутствия - введите '0'):");
        int motherID;
        String userInput = scanner.nextLine();
        if (userInput.equals("0")) {
            return 0;
        } else {
            try {
                motherID = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
                motherID = getMotherID();
            }
        }
        return motherID;
    }

    private int getFatherID() {
        System.out.println("\nВведите ID отца (в случае отсутствия - введите '0'):");
        int fatherID;
        String userInput = scanner.nextLine();
        if (userInput.equals("0")) {
            return 0;
        } else {
            try {
                fatherID = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
                fatherID = getFatherID();
            }
        }
        return fatherID;
    }

    //TODO Проблема с вызовом этого метода, если человек введет снчала 112.12.1956, а потом 12.12.1956 То в итоге конвертируется первая дата, почему?
    private LocalDate getBirthDate() {
        LocalDate birthDate;
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ:");
        String dateStr = scanner.nextLine();
        if (!dateStr.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{1,4}")) {
            System.out.println("Дата рождения введена неверно! Ожидаются цифры в формате ДД.ММ.ГГГГ.");
            birthDate = getBirthDate();
        }
        if (dateStr.matches("\\d\\.\\d{2}\\.\\d{4}")) {
            dateStr = "0" + dateStr;
        }
        else if (dateStr.matches("\\d{2}\\.\\d\\.\\d{4}")) {
            dateStr = dateStr.substring(0, 3) + "0" + dateStr.substring(3);
        }
        else if (dateStr.matches("\\d\\.\\d\\.\\d{4}")) {
            dateStr = "0" + dateStr.substring(0, 2) + "0" + dateStr.substring(2);
        }
        String[] dateStrArray = dateStr.split("\\.");
        int[] dateIntArray = new int[dateStrArray.length];
//        System.out.println(dateStr); // TEST

        //TODO Почему не работает try-catch? Приложение падает при вводе 12.22.1999 (22 месяц) хотя есть catch на DateTimeException
        try {
            for (int i = 0; i < dateStrArray.length; i++) {
                dateIntArray[i] = Integer.parseInt(dateStrArray[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Дата рождения введена неверно! Ожидаются цифры в формате ДД.ММ.ГГГГ.");
            birthDate = getBirthDate();
        }

        int day = dateIntArray[0];
        int month = dateIntArray[1];
        int year = dateIntArray[2];


        System.out.println("STR array:");
        for (String string : dateStrArray) {
            System.out.println("    " + string);
        }
        System.out.println("INT array:");
        for (int i : dateIntArray) {
            System.out.println("    " + i);
        }


        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println("Некорректная дата! Проверьте значения дня, месяца и года.");
            birthDate = getBirthDate();
        }
        return birthDate;
    }

    private Gender getGender() {
        System.out.println("Выберите пол:");
        System.out.println("1 - М");
        System.out.println("2 - Ж");
        String choice = scanner.nextLine();
        Gender gender;
        if (choice.equals("1") || choice.equalsIgnoreCase("М")) {
            gender = Gender.Male;
        } else if (choice.equals("2") || choice.equalsIgnoreCase("Ж")) {
            gender = Gender.Female;
        } else {
            System.out.println("Неверный ввод! Ожидается '1' или '2' / 'М' или 'Ж'.");
            gender = getGender();
        }
        return gender;
    }

    private String getName() {
        System.out.print("Введите имя человека: ");
        String name = scanner.nextLine();
        return name;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}
