package org.youthnet.export.util;

import org.youthnet.export.domain.CSVable;
import org.youthnet.export.io.CSVFileReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: karl
 * Date: 06-Jul-2010
 */
public class CSVUtil {
    private CSVUtil() {
    }

    public static <T extends CSVable> List<T> createDomainList(String filePath, Class<T> type) {
        List<T> domainObjects = null;
        CSVFileReader csvFileReader = null;

        try {
            csvFileReader = new CSVFileReader(new FileReader(filePath));
            domainObjects = new ArrayList<T>();

            String record = "";
            T domainObject = null;
            while ((record = csvFileReader.readRecord()) != null) {
                try {
                    domainObject = type.newInstance();
                    domainObject.init(record);
                    domainObjects.add(domainObject);
                } catch (InstantiationException e) {
                    System.out.println("Could not instantiate " + type.getName() + ". Error: " + e.getMessage());
                    break;
                } catch (IllegalAccessException e) {
                    System.out.println("Could not access " + type.getName() + ". Error: " + e.getMessage());
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("File " + filePath + " not found. Error: " + e.getMessage());
        } finally {
            if (csvFileReader != null) {
                try {
                    csvFileReader.close();
                } catch (IOException e) {
                    System.out.println("Could not close file stream. Error: " + e.getMessage());
                }
            }
        }

        return domainObjects;
    }
}
