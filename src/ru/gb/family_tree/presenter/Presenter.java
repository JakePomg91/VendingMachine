package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }


    public void addHuman(String name, Gender gender, LocalDate birthDate, int fatherID, int motherID) {
        service.addHuman(new Human(name, gender, birthDate, (Human) service.findByID(fatherID), (Human) service.findByID(motherID)));
    }

    public String getFamilyTreeInfo() {
        return service.getFamilyTreeInfo();
    }

    public void sortByID() {
        service.sortByID();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByChildrenCount() {
        service.sortByChildrenCount();
    }

    public String findByName(String name) {
        return service.findByName(name);
    }
}
