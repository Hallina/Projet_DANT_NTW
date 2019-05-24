package index;

import java.util.HashMap;
import Models.Where;

public class IndexColumn {
	
	private static int cpt_indexcol = 0;
	private int key;
    private HashMap<Integer, String> values;

    public IndexColumn() {
    	values = new HashMap<>();
    	key = cpt_indexcol++;
    }
    
    public int getKey() {
    	return key;
    }
    
    public HashMap<Integer, String> getValues() {
    	return values;
    }

    public void insert(String value){
    	int i = 0;
    	while(values.containsKey(i)) {
    		i++;
    	}
        values.put(i,value);
    }
}