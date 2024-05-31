package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyTree {
    private List<Human> familyList = new ArrayList<>();

    public FamilyTree() {
        this.familyList = familyList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree: \n");
        String name = "ds";
        for (Human human : familyList) {
            if (!stringBuilder.toString().contains(human.toString())){
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
    }
}
