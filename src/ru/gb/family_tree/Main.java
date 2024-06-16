package ru.gb.family_tree;

import java.time.LocalDate;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.family_tree.saver.FileHandler;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

public class Main {

    public static void main(String[] args) {

        ConsoleUI view = new ConsoleUI();
        view.start();

    }

}