package index;

import java.util.ArrayList;
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
        int position = CSVParser.getChamps().indexOf(where.getField());
        return indexes.get(position);
    }
    
    /*public ArrayList<Object> select(ArrayList<String> champs, ArrayList<Where> wheres){
    	ArrayList<Object> res = new ArrayList<>();
    	int key = 0;
    	for(Where w : wheres) {
    		Index i = from(champs, w);
    		Set s = i.getValues().entrySet();
    		//Parcours les valeurs de la hashmap de i par clé
    		while() {
    			String strToCompare = i.getValues().get(key);
    			if(strToCompare.equals(w.getValue())){
    				res.add(strToCompare);
    			}
    			key++;
    		}
    	}
    	return res;
    }
    
    // get without index
    public ArrayList<Object[]> getWithoutIndex(int indexPosition, String value){
        //Full Scan
        ArrayList<Object[]> res = new ArrayList<>();
        for(Object[] line : CSVParser.getLines()){
            if (line[colPosition].equals(value)) {
                res.add(line);
            }
        }
        return res;
    }

    // Id without Index
    public ArrayList<Integer> getRowIdsWithoutIndex(int colPosition, String value){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < CSVParser.getLines().size() ; i++){
            if (CSVParser.getLines().get(i)[colPosition].equals(value)) {
                res.add(i);
            }
        }
        return res;
    }*/

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
