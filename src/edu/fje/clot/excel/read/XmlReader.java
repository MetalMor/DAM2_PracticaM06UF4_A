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
import jxl.Workbook;

/**
 *
 * @author m0r
 */
public class XmlReader implements XmlFile {
    private Workbook _wb;
    
    public XmlReader(File file) {
        setFile(file);
    }
    
    public XmlReader(String filePath) {
        setFile(filePath);
    }
    
    public List<Evaluation> getEvaluations() {
        List<Evaluation> evaluations = new ArrayList<>();
        Sheet sheet = _wb.getSheet(0);
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
    
    @Override
    public final void setFile(File file) {
        try {
        _wb = Workbook.getWorkbook(file);
        } catch (Exception ex) {
            System.err.println("Could not read file: " + file.getPath());
        }
    }
    
    @Override
    public final void setFile(String filePath) {
        setFile(new File(filePath));
    }
}
