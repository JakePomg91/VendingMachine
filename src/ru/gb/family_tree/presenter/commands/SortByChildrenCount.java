package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByChildrenCount extends Command {

    public SortByChildrenCount(ConsoleUI consoleUI) {
        super("Отсортировать древо по количеству детей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByChildrenCount();
    }
}
