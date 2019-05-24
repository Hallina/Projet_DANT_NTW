package index;

import java.util.ArrayList;
import java.util.Objects;

public class Table {

    private String name;
    private ArrayList<Index> indexes;
    
    public Table(String name) {
    	this.name = name;
    	indexes = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public ArrayList<Index> getIndexes() {
        return indexes;
    }
    
    public void ajouterIndex() {
    	indexes.add(new Index());
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
