package index;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import Models.Where;

public class Index {
    private static int cpt_index = 0;
    private int id;
    private HashMap<Integer, IndexColumn> indexByColumns;
    public Index() {
    	id = cpt_index++;
        indexByColumns = new HashMap<>();
        indexByColumns.put(id, new IndexColumn());
    }
    
    public int getId() {
    	return id;
    }
    
    public Set<Entry<Integer, IndexColumn>> getIndexByColumns(){
    	return indexByColumns.entrySet();
    }

    /*public ArrayList<Object[]> get(ArrayList<String> colNames, ArrayList<Where> wheres) {
        //Scan by wheres
        for (Where where : wheres) {
            int position = colNames.indexOf(where.getField());
            if (position == -1) {
                getRowIdsWithoutIndex(position, where.getValue());
            } else {
                indexByColumns.get(position).get(where.getValue());
            }
        }
        //TODO a modifier
        return null;
    }

    // get without index
    public ArrayList<Object[]> getWithoutIndex(int colPosition, String value){
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

}
