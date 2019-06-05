package index;

import java.util.List;
import java.util.Objects;

public class Table {

    private String name;
    private List<String> columns;
    private List<Index> indexes;
    private List<Object[]> lines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<Index> getIndexes() {
        return indexes;
    }

    public void insert(Object[] line) {
        for (Index index : indexes) {
            index.insert(line);
        }
    }

    public void addIndex(Index index) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return name.equals(table.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
