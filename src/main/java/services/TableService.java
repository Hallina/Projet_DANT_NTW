package services;

import index.Table;

import java.util.HashMap;
import java.util.Map;

public class TableService {

    private static Map<String, Table> tables = new HashMap<>();

    public void add(Table table) {
        if (tables.containsKey(table.getName())) {
            //TODO : Send error
            return;
        }
        tables.put(table.getName(), table);
    }

    public Table get(String name) {
        return tables.get(name);
    }

}
