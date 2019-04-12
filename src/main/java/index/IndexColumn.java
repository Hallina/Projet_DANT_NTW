package index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexColumn {

    private List<Object[]> lines;
    private Map<String, List<Integer>> index = new HashMap<>();

    public IndexColumn(List<Object[]> lines) {
        this.lines = lines;
    }

    public void insert(String key){
        int nbLine = lines.size();
        List<Integer> rows = getRowsIds(key);
        if (rows == null){
            rows = new ArrayList<>();
            index.put(key, rows);
        }
        rows.add(nbLine);
    }

    public List<Object[]> get(String key){
        return get(getRowsIds(key));
    }


    public List<Object[]> get(List<Integer> rows){
        if (rows == null)
            return null;
        List<Object[]> result = new ArrayList<>();
        for (Integer row : rows){
            result.add(lines.get(row));
        }
        return result;
    }

    public List<Integer> getRowsIds(String key) {
        return index.get(key);
    }
}
