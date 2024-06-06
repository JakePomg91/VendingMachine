package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByChildrenCount;
import ru.gb.family_tree.tree.iterators.EIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeGeneric<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree: \n");
        for (E e : humanList) {
            if (!stringBuilder.toString().contains(e.toString())) {
                stringBuilder.append(e);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new EIterator<E>(humanList);
    }

    public void addHuman(E e) {
        humanList.add(e);
        if (e.getFather() != null) {
            if (e.getFather().getChildren() == null) {
                e.getFather().setChildren(Arrays.asList(e));
            } else {
                e.getFather().addChildren(e);
            }
        }
        if (e.getMother() != null) {
            if (e.getMother().getChildren() == null) {
                e.getMother().setChildren(Arrays.asList(e));
            } else {
                e.getMother().addChildren(e);
            }
        }
    }

    public E findByName(String name) {
        for (E e : humanList) {
            if (e.getName().equals(name)) {
                System.out.print(e);
                System.out.println(childrenToString(e.getChildren()));
                return e;
            }
        }
        return null;
    }

    private String childrenToString(List<E> children) {
        if (children == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (E eChild : children) {
            stringBuilder.append("\n");
            stringBuilder.insert(stringBuilder.length(), "  |=>> ");
            stringBuilder.append(eChild.toString());
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        Collections.sort(humanList);
//        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortByChildrenCount() {
        humanList.sort(new HumanComparatorByChildrenCount<>());
    }
}
