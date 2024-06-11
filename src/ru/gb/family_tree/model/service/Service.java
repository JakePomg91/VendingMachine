package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeGeneric;

public class Service<E> {
    private FamilyTree familyTree;
    private E human;


    public Service() {
        familyTree = new FamilyTree<>();
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

    public FamilyTree getTree(){
        return familyTree;
    }

}
