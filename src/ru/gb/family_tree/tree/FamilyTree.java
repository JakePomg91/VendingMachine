package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByChildrenCount;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;
import ru.gb.family_tree.tree.iterators.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree: \n");
        for (Human human : humanList) {
            if (!stringBuilder.toString().contains(human.toString())) {
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void addHuman(Human human) {
        humanList.add(human);
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
        for (Human human : humanList) {
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

    public void sortByName() {
//        Collections.sort(humanList);
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortByChildrenCount() {
        humanList.sort(new HumanComparatorByChildrenCount());
    }
}
