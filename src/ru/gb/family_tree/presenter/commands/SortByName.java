package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать древо по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
