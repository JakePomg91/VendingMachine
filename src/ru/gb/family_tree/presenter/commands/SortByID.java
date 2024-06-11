package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByID extends Command {

    public SortByID(ConsoleUI consoleUI) {
        super("Отсортировать древо по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByID();
    }
}
