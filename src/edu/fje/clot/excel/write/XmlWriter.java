package edu.fje.clot.excel.write;

import edu.fje.clot.excel.Evaluation;
import edu.fje.clot.excel.XmlFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author m0r
 */
public class XmlWriter implements XmlFile {
    private WritableWorkbook _wb;

    public XmlWriter(File file) {
        setFile(file);
    }
    
    public XmlWriter(String filePath) {
        setFile(filePath);
    }
    
    public void writeEvaluations(List<Evaluation> evaluations) {
        WritableSheet sheet = _wb.createSheet("Notes", 0);
        int length = evaluations.size();
        Evaluation evaluation;
        float evaluationValue;
        WritableFont evaluationValueFont;
        WritableCellFormat evaluationValueCellFormat;
        for (int index = 0; index < length; index++) {
            evaluation = evaluations.get(index);
            evaluationValue = evaluation.getEvaluation();
            evaluationValueFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
            evaluationValueCellFormat = new WritableCellFormat(evaluationValueFont);
            try {
                sheet.addCell(new Label(0, index, evaluation.getName()));
                sheet.addCell(new Label(1, index, String.valueOf(evaluationValue), evaluationValueCellFormat));
                sheet.addCell(new Label(2, index, evaluationValue < 5 ? "Suspes" : "Aprovat"));
            } catch (WriteException ex) {
                System.err.println("Could not write cell at index number " + index + ".");
            }
        }
        try {
            _wb.close();
        } catch (Exception ex) {
            System.err.println("Could not close XLS file.");
        }
    }
    
    @Override
    public final void setFile(File file) {
        try {
            _wb = Workbook.createWorkbook(file);
        } catch (Exception ex) {
            System.err.println("Could not create file: " + file.getPath());
        }
    }
    
    @Override
    public final void setFile(String filePath) {
        setFile(new File(filePath));
    }
    
}
