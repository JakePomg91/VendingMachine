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

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    public void addHuman() {
        String name = getName();
        Gender gender = getGender();
        LocalDate birthDate = getBirthDate();
        sortByID();
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

    public void saveTree() {
        System.out.println("Последнее сохранение будет перезаписанно на это! Вы уверены что хотите сохранить древо?");
        if (isUserSure()) {
            presenter.saveTree();
            System.out.println("Древо было успешно сохранено!");
        } else {
            System.out.println("Сохранение отменено!");
        }
    }

    public void loadTree() {
        System.out.println("Текущее древо будет удалено безвозвратно! Вы уверены что хотите загрузить сохраненное?");
        if (isUserSure()) {
            presenter.loadTree();
            getFamilyTreeInfo();
        } else {
            System.out.println("Загрузка отменена!");
        }
    }

    public void finish() {
        work = false;
        System.out.println("До свидания!");
    }



    private boolean isUserSure() {
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        String choice = scanner.nextLine();
        if (choice.equals("1") || choice.equalsIgnoreCase("Да")) {
            return true;
        } else if (choice.equals("2") || choice.equalsIgnoreCase("Нет")) {
            return false;
        } else {
            System.out.println("Выберите один из перечисленных ответов!");
            return isUserSure();
        }
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

    private LocalDate getBirthDate() {
        LocalDate birthDate;
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ:");
        String dateStr = scanner.nextLine();
        if (!dateStr.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{1,4}")) {
            System.out.println("Дата рождения введена неверно! Ожидаются цифры в формате ДД.ММ.ГГГГ.");
            return getBirthDate();
        } else if (dateStr.matches("\\d\\.\\d{2}\\.\\d{4}")) {
            dateStr = "0" + dateStr;
        } else if (dateStr.matches("\\d{2}\\.\\d\\.\\d{4}")) {
            dateStr = dateStr.substring(0, 3) + "0" + dateStr.substring(3);
        } else if (dateStr.matches("\\d\\.\\d\\.\\d{4}")) {
            dateStr = "0" + dateStr.substring(0, 2) + "0" + dateStr.substring(2);
        }
        String[] dateStrArray = dateStr.split("\\.");
        int[] dateIntArray = new int[dateStrArray.length];

        try {
            for (int i = 0; i < dateStrArray.length; i++) {
                dateIntArray[i] = Integer.parseInt(dateStrArray[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Дата рождения введена неверно! Ожидаются цифры в формате ДД.ММ.ГГГГ.");
            return getBirthDate();
        }


        int day = dateIntArray[0];
        int month = dateIntArray[1];
        int year = dateIntArray[2];


        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println("Некорректная дата! Проверьте значения дня, месяца и года.");
            return getBirthDate();
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

}
