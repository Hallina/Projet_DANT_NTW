package index;

import java.util.HashMap;

public class Index {
    private static int cpt_index = 0;
    private int column;
    private HashMap<Integer, String> values;
  
    public Index() {
    	column = cpt_index++;
        values = new HashMap<>();
    }
    
    public int getColumn() {
    	return column;
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
