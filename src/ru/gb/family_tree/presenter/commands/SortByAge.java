package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать древо по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
