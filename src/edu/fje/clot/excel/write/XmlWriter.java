package edu.fje.clot.excel.write;

import edu.fje.clot.excel.XmlFile;
import java.io.File;

/**
 *
 * @author m0r
 */
public class XmlWriter extends XmlFile {

    public XmlWriter(File file) {
        super(file);
    }
    
    public XmlWriter(String filePath) {
        super(filePath);
    }
    
}
