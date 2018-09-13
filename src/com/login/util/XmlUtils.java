package com.login.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlUtils {
    private static String realPath;
    static {
    	realPath = "C:\\Users\\HerbertPu\\workspace\\MVCDemo\\src\\DB.xml";
        //realPath = XmlUtils.class.getClassLoader().getResource("DB.xml").getPath();
        //System.out.println(realPath);
    }

    public static Document getDocument() throws DocumentException {

        SAXReader reader = new SAXReader();
        return reader.read(new File(realPath));

    }

    public static void write2Xml(Document document) throws IOException {

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream(realPath), format );
        writer.write( document );
        writer.close();

    }
}
