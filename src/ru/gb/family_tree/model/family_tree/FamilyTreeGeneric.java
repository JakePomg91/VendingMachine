package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeGeneric<E> extends Comparable<E> {
    int getID();
    String getName();
    E getFather();
    E getMother();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<E> getChildren();
    void setChildren(List<E> e);
    void addChildren(E e);
    int getAge(LocalDate birthDate, LocalDate DeathDate);
}
