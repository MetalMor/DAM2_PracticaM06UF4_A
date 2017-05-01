package edu.fje.clot.excel.read;

import edu.fje.clot.excel.Evaluation;
import edu.fje.clot.excel.XmlFile;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;

/**
 *
 * @author m0r
 */
public class XmlReader extends XmlFile {
    
    public XmlReader(File file) {
        super(file);
    }
    
    public XmlReader(String filePath) {
        super(filePath);
    }
    
    public List<Evaluation> getEvaluations() {
        List<Evaluation> evaluations = new ArrayList<>();
        Sheet sheet = getWorkbook().getSheet(0);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("0.#");
        format.setDecimalFormatSymbols(symbols);
        String name;
        Float evaluation;
        for(int index = 12; index < 34; index++) {
            name = sheet.getCell(0, index).getContents();
            try {
                evaluation = format.parse(sheet.getCell(2, index).getContents()).floatValue();
            } catch (ParseException ex) {
                System.err.println("Could not parse " + name.split(", ")[1] + "'s evaluation");
                evaluation = Float.NaN;
            }
            evaluations.add(new Evaluation(name, evaluation));
        }
        return evaluations;
    }
}
