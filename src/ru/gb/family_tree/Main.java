package ru.gb.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.tree.saver.FileHandler;

public class Main {
    /**
     *
     */
    public static void main(String[] args) {
//        FamilyTree familyTree = new FamilyTree();
        String filePath = "src/ru/gb/family_tree/tree/saver/tree_save.txt";

//        Human human1_1 = new Human("Anatoliy", Gender.Male, LocalDate.of(1984, 12, 4), LocalDate.of(2008, 11, 21));
//        Human human1_2 = new Human("Svetlana", Gender.Female, LocalDate.of(1991, 5, 24));
//
//        Human human2_1 = new Human("Sergey", Gender.Male, LocalDate.of(1991, 9, 30), human1_1, human1_2);
//        Human human2_2 = new Human("Maria", Gender.Female, LocalDate.of(1980, 8, 15), human1_1, human1_2);
//        Human human2_3 = new Human("Alexandr", Gender.Male, LocalDate.of(2009, 1, 14), null, null);
//
//        Human human3_1 = new Human("Viktor", Gender.Male, LocalDate.of(1999, 5, 10), human2_3, human2_1);
//        Human human3_2 = new Human("Valeriy", Gender.Male, LocalDate.of(2001, 7, 19), human1_1, human1_2);
//
//
//        familyTree.addHuman(human1_1);
//        familyTree.addHuman(human1_2);
//        familyTree.addHuman(human2_1);
//        familyTree.addHuman(human2_2);
//        familyTree.addHuman(human2_3);
//        familyTree.addHuman(human3_1);
//        familyTree.addHuman(human3_2);
//
//        save(familyTree, filePath);

        FamilyTree familyTree2 = load(filePath);

        System.out.println("\n Loaded:");
        System.out.println(familyTree2);

        System.out.println("\n Searching by name:");
        familyTree2.findByName("Svetlana");



        System.out.println("\n Iterator working:");
        for (Human human : familyTree2) {
            System.out.println(human);
        }

        familyTree2.sortByName();
        System.out.println("\n Sorted by name:");
        System.out.println(familyTree2);

        familyTree2.sortByAge();
        System.out.println("\n Sorted by age:");
        System.out.println(familyTree2);

        familyTree2.sortByChildrenCount();
        System.out.println("\n Sorted by children count");
        System.out.println(familyTree2);
    }

    private static void save(FamilyTree tree, String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    private static FamilyTree load(String filePath) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.load(filePath);
    }

}