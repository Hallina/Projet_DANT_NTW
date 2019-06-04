package index;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Objects;
import Models.Where;

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
    
    public Index from(ArrayList<String> champs, Where where) {
        //Récupération de zone de recherche (FROM)
        int position = champs.indexOf(where.getField());
        return indexes.get(position);
    }
    
    public ArrayList<String> select(ArrayList<String> champs, ArrayList<Where> wheres){
    	ArrayList<String> res = new ArrayList<>();
    	String line = null;
    	String[] line_to_add = null;
    	
    	for(Where w : wheres) {
    		Index i = from(champs, w);
    		//Parcours les valeurs de la hashmap de i par clé
    		for(Entry<Integer, String> keyvalue : i.getValues().entrySet()) {
    			int key = keyvalue.getKey();
    			String strToCompare = keyvalue.getValue();
    			if(strToCompare.equals(w.getValue())){
    				line_to_add = CSVParser.getLines().get(key);
    			}
    		}
    		line = "";
    		for(int ind = 0; ind < line_to_add.length; ind++) {
    			line += line_to_add[ind] + ",";
    		}
    		res.add(line);
    	}
		return res;
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
