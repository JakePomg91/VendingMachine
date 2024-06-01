package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree: \n");
        for (Human human : familyList) {
            if (!stringBuilder.toString().contains(human.toString())) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void addHuman(Human human) {
        familyList.add(human);
        if (human.getFather() != null) {
            if (human.getFather().getChildren() == null) {
                human.getFather().setChildren(Arrays.asList(human));
            } else {
                human.getFather().addChildren(human);
            }
        }
        if (human.getMother() != null) {
            if (human.getMother().getChildren() == null) {
                human.getMother().setChildren(Arrays.asList(human));
            } else {
                human.getMother().addChildren(human);
            }
        }
    }

    public Human findByName(String name) {
        for (Human human : familyList) {
            if (human.getName().equals(name)) {
                System.out.print(human);
                System.out.println(childrenToString(human.getChildren()));
                return human;
            }
        }
        return null;
    }

    private String childrenToString(List<Human> children) {
        if (children == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append("\n");
            stringBuilder.insert(stringBuilder.length(), "  |=>> ");
            stringBuilder.append(child.toString());
        }
        return stringBuilder.toString();
    }

}
