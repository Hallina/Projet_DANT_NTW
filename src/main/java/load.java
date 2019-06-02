// Load csv
// rsc : https://thierry-leriche-dessirier.developpez.com/tutoriels/java/charger-donnees-fichier-csv-5-min/

import au.com.bytecode.opencsv.CSVReader;
import index.Table;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class load {

    // path of files
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String RS_FILE_NAME;

    // separator
    private final static char SEPARATOR = ';';

    // function to load table
    public List<Table> loadTable(String file_name) {

        File file = new File(RESOURCES_PATH + file_name);
        FileReader fr = new FileReader(file);

        CSVReader csvReader = new CSVReader(fr, SEPARATOR);

        // Reading data
        List<String[] > data = new ArrayList<String[] >();

        String[] nextLine = null;
        while ((nextLine = csvReader.readNext()) != null) {
            int size = nextLine.length;

            // ligne vide
            if (size == 0) {
                continue;
            }
            String debut = nextLine[0].trim();
            if (debut.length() == 0 && size == 1) {
                continue;
            }

            // ligne de commentaire
            if (debut.startsWith("#")) {
                continue;
            }
            data.add(nextLine);
        }
        // End reading data

        List<Table> lines = new ArrayList<Table>();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String[] oneData : data) {
            // TODO: line with columns
            //String name = ondeData[0];


        }

        return lines;
    }
}
