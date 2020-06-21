package com.possystem.app.core;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemEntry {

    private final SimpleStringProperty no = new SimpleStringProperty("1");
    private final SimpleStringProperty itemCode = new SimpleStringProperty("");
    private final SimpleStringProperty Name = new SimpleStringProperty("");

    public ItemEntry()
    {
        this("1","abc","def");
    }

    public ItemEntry(String no1,String itecode,String name) {
        no.set(no1);
        itemCode.set(itecode);
        Name.set(name);
    }


}
