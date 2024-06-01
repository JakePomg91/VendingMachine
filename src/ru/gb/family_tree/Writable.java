package ru.gb.family_tree;

import java.io.Serializable;

public interface Writable{
    void save(Serializable serializable, String filePath);
    Object load(String filePath);
}
