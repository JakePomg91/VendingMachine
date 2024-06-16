package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeGeneric;
import ru.gb.family_tree.model.family_tree.saver.FileHandler;
import ru.gb.family_tree.model.human.Creature;
import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.util.List;

public class Service<E extends Creature> {
    private FamilyTree familyTree;
    private E human;
    String filePath;


    public Service() {
        familyTree = new FamilyTree<>();
        filePath = "src/ru/gb/family_tree/model/family_tree/saver/tree_save.txt";
    }

    public void addHuman(E e) {
        familyTree.addHuman((FamilyTreeGeneric) e);
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();
        for (Object o : familyTree) {
            sb.append(o);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByID() {
        familyTree.sortByID();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByChildrenCount() {
        familyTree.sortByChildrenCount();
    }

    public String findByName(String name) {
        return familyTree.findByName(name);
    }

    public E findByID(int id) {
        return (E) familyTree.findByID(id);
    }

    public FamilyTree getTree() {
        return familyTree;
    }

    public void saveTree() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    public void loadTree() {
        FileHandler fileHandler = new FileHandler();
        familyTree = (FamilyTree) fileHandler.load(filePath);
        // TODO попытка решить проблему с ID
//        if (familyTree != null && human != null) {
//            human.setHumanCounter(familyTree.getSize());
//            System.out.println("ЗАШЁЛ В if");
//        }
    }

}
