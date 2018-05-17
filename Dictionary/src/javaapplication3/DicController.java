/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.sun.javafx.collections.MappingChange;
import java.awt.List;
import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author An Nguyen
 */
public class DicController {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public static String doc(String key) throws ParserConfigurationException, SAXException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("Viet_Anh.xml");
        document.getDocumentElement().normalize();
        System.out.println(document.getDocumentElement().getNodeName());
        NodeList nList = document.getElementsByTagName("record");
        System.out.println("----------------------------");
        String[] tu = null;
        String[] nghia;
        String word;
        String meaning;
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            //System.out.println(nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                //System.out.println(element.getAttribute(""));
word = element.getElementsByTagName("word").item(0).getTextContent();
meaning = element.getElementsByTagName("meaning").item(0).getTextContent();
                map.put( word, meaning);
               
            }
        }
       return map.get(key);
    }
    public static String read(String key) throws ParserConfigurationException, SAXException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("Anh_Viet.xml");
        document.getDocumentElement().normalize();
        System.out.println(document.getDocumentElement().getNodeName());
        NodeList nList = document.getElementsByTagName("record");
        System.out.println("----------------------------");
        String[] tu = null;
        String[] nghia;
        String word;
        String meaning;
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            //System.out.println(nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                //System.out.println(element.getAttribute(""));
word = element.getElementsByTagName("word").item(0).getTextContent();
meaning = element.getElementsByTagName("meaning").item(0).getTextContent();
                map.put( word, meaning);
               
            }
        }
       return map.get(key);
    }
    
}
