package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class FindByName extends Command {

    public FindByName(ConsoleUI consoleUI) {
        super("Поиск человека по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findByName();
    }
}
