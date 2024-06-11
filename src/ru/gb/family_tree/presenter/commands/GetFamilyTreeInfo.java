package ru.gb.family_tree.presenter.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Вывести древо в консоль", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
