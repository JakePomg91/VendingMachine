package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeGeneric;

import java.util.Comparator;

public class HumanComparatorByChildrenCount<E extends FamilyTreeGeneric<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
