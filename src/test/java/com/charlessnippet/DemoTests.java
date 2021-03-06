package com.charlessnippet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// @Disabled("Disable as these are demo test cases")
public class DemoTests
{
    Logger logger = LogManager.getLogger(DemoTests.class);

    @BeforeAll
    public static void setUp() {
        // TODO
    }

    @BeforeEach
    public void configureTools() {
        logger.info("Start testing " + this.getClass().getSimpleName());
    }

    @AfterEach
    public void tearDown() {
        logger.info("Closing the test " + this.getClass().getSimpleName());
        logger.traceExit();
    }
    
    @Test
    @Tag("demo")
    public void test_utility()
    {
        // assertEquals(DiaNumberFormat.stripTrailingZeros("asd"), "asd");
        // assertEquals(DiaNumberFormat.stripTrailingZeros("0.0"), "0");
        // assertEquals(DiaNumberFormat.stripTrailingZeros("1"), "1");
        // assertEquals(DiaNumberFormat.stripTrailingZeros("1.01"), "1.01");
        // assertEquals(DiaNumberFormat.stripTrailingZeros("1.010"), "1.01");
        // assertEquals(Utility.splitYearField(null, "yearEnd"), null);
        // assertEquals(new BigDecimal("3600").stripTrailingZeros().toString(), "3600"); // this one will fail
        
        logger.info("Start testing demo test case ...");
        assertEquals(new BigDecimal("0.0").stripTrailingZeros().toString(), "0");
        assertEquals(new BigDecimal("2.0").stripTrailingZeros().toString(), "2");
        assertEquals(new BigDecimal("2.50").stripTrailingZeros().toString(), "2.5");
        // assertEquals(DiaNumberFormat.roundedToTwoDecimalPlaces("11", null), "11.00");
        // assertEquals(DiaNumberFormat.roundedToTwoDecimalPlaces("1.0", null), "1.00");
        // assertEquals(DiaNumberFormat.roundedToTwoDecimalPlaces("0", null), "0.00");
        // assertEquals(DiaNumberFormat.roundedToTwoDecimalPlaces("11.155", null), "11.16");
        // assertEquals(Utility.changeDateFormat("2010-07-09 17:47:35.98", "yyyy-MM-dd hh:mm:ss", "yyyy-MM-dd"), "2010-07-09");
        // logger.info("All assertEquals in test_utility pass!");
    }

    @Disabled("Move this method to class XmlParser")
    @Test
    @Tag("demo")
    public void xmlExtractionDemo() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\xml\\demo\\demo.xml";
        List<String> columnsToExtract = Arrays.asList("vn", "vN", "nL");

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dDoc = builder.parse(filepath);
    
        XPath xPath = XPathFactory.newInstance().newXPath();

        NodeList fields = (NodeList) xPath.evaluate("//record/field", dDoc, XPathConstants.NODESET);
        ArrayList<ArrayList<String>> fieldValueInList = new ArrayList<>();
        for (int j = 0; j < columnsToExtract.size(); j++) {
            ArrayList<String> fieldValues = new ArrayList<String>();
            for (int i = 0; i < fields.getLength(); i++) {
                Node node = fields.item(i);
                if (node.getAttributes().getNamedItem("tag").getTextContent().equals(columnsToExtract.get(j)))
                {
                    // logger.info("How do I add this string '" + node.getTextContent() + "' as an arraylist item into an arraylist whose name is " + columnsToExtract.get(j) + " ??????");
                    fieldValues.add(node.getTextContent());
                }
            }
            if (fieldValues.size()>0) {fieldValueInList.add(fieldValues);}
        }

        logger.info("values for vn: " + fieldValueInList.get(0));
        logger.info("values for vN: " + fieldValueInList.get(1));
        logger.info("values for nL: " + fieldValueInList.get(2));
    }

}
