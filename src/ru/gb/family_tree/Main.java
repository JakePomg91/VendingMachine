package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1_1 = new Human("Anatoliy", Gender.Male, LocalDate.of(1984, 12, 4), LocalDate.of(2008, 11, 21));
        Human human1_2 = new Human("Svetlana", Gender.Female, LocalDate.of(1991, 5, 24));
        Human human2_1 = new Human("Sergey", Gender.Male, LocalDate.of(1991, 9, 30), human1_1, human1_2);
        Human human2_2 = new Human("Maria", Gender.Female, LocalDate.of(1980, 8, 15), human1_1, human1_2);


        Human human2_3 = new Human("Alexandr", Gender.Male, LocalDate.of(2009, 1, 14), null, null);
        Human child2 = new Human("Viktor", Gender.Male, LocalDate.of(1999, 5, 10), null, null);
        Human child3 = new Human("Valeriy", Gender.Male, LocalDate.of(2001, 7, 19), null, null);


        familyTree.addHuman(human1_1);
        familyTree.addHuman(human1_2);
        familyTree.addHuman(human2_1);
        familyTree.addHuman(human2_2);


        System.out.println(familyTree);


    }
}