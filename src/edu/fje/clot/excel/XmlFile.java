/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.fje.clot.excel;

import java.io.File;
import jxl.Workbook;

/**
 *
 * @author m0r
 */
public class XmlFile {
    private Workbook _wb;
    
    public XmlFile(File file) {
        setFile(file);
    }
    
    public XmlFile(String filePath) {
        setFile(filePath);
    }
    
    protected Workbook getWorkbook() {
        return _wb;
    }
    
    public final void setFile(File file) {
        try {
        _wb = Workbook.getWorkbook(file);
        } catch (Exception ex) {
            System.err.println("Could not read file: " + file.getPath());
        }
    }
    
    public final void setFile(String filePath) {
        setFile(new File(filePath));
    }
}
