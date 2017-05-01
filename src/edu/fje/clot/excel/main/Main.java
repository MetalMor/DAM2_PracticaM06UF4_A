package edu.fje.clot.excel.main;

import edu.fje.clot.excel.Evaluation;
import edu.fje.clot.excel.read.XmlReader;
import edu.fje.clot.excel.write.XmlWriter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m0r
 */
public class Main {
    
    private static final String USER_HOME_DIR_PATH = System.getProperty("user.home");
    private static final String INPUT_FILE_PATH = USER_HOME_DIR_PATH + "/Documentos/cole/Notes_2DAM_M06UF1_2016_17.xls";
    private static final String OUTPUT_FILE_PATH = USER_HOME_DIR_PATH + "/M06UF1_NotesExamenFinal.xls";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new XmlWriter(OUTPUT_FILE_PATH).writeEvaluations(
                new XmlReader(INPUT_FILE_PATH).getEvaluations()
        );
    }
    
}
