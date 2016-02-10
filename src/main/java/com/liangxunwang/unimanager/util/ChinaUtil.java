package com.liangxunwang.unimanager.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/1/30.
 */
public class ChinaUtil {
    private static ChinaUtil districtUtil = new ChinaUtil();


    public static ChinaUtil getDistrict() {
        return districtUtil;
    }

    private DistrictCell cell;

    public Map<String, String> getMap() {
        return map;
    }

    private Map<String, String> map = new HashMap<String, String>();

    private ChinaUtil() {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(ChinaUtil.class.getResource("china.xml"));
            Element root = doc.getRootElement();
            cell = new DistrictCell();
            findDistrict(cell, root);
        } catch (DocumentException e) {
            throw new InternalError(e.getMessage());
        }
    }

    private void findDistrict(DistrictCell rootCell, Element rootElement) {
        List list = rootElement.selectNodes("prefecture");
        if (list.isEmpty()) {
            return;
        }
        List<DistrictCell> cellList = new ArrayList<DistrictCell>();
        for (Object object : list) {
            Element e = (Element) object;
            DistrictCell temp = new DistrictCell();
            temp.setNo(e.attributeValue("no"));
            temp.setName(e.attributeValue("name"));
            map.put(temp.getNo(), temp.getName());
            cellList.add(temp);
            findDistrict(temp, e);
        }
        rootCell.setList(cellList);
    }

    public DistrictCell getDistrictCell() {
        return cell;
    }

    public String getDistrictNameAll(String no, int level) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(ChinaUtil.class.getResource("china.xml"));
            String temp = "/prefecture";
            String temp2 = "";
            while(level > 0){
                temp2 += temp;
                level--;
            }

            String xpath = "/china" + temp2 + "[@no='" + no + "']";
            List list = doc.selectNodes(xpath);
            if(list != null && !list.isEmpty()) {
                Element e = (Element) list.get(0);
                return e.attributeValue("name");
            }

//            List list = doc.selectNodes(xpath);
//            for (Object object : list) {
//                Element e = (Element) object;
//                if(e.attributeValue("no").equals(no)) {
//                    System.out.println(e.attributeValue("name"));
//                }
//            }
        } catch (DocumentException e) {
            throw new InternalError(e.getMessage());
        }
        return "";
    }

    public String getDistrictName(String[] nos) {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(ChinaUtil.class.getResource("china.xml"));
            Element root = doc.getRootElement();
            List list = root.selectNodes("prefecture");
            for (Object object : list) {
                Element e = (Element) object;
                map.put(e.attributeValue("no"), e.attributeValue("name"));
            }
        } catch (DocumentException e) {
            throw new InternalError(e.getMessage());
        }
        StringBuffer names = new StringBuffer();
        for (int i = 0; i < nos.length; i++) {
            names.append(map.get(nos[i]));
            if (i != nos.length - 1) {
                names.append(",");
            }
        }
        return names.toString();
    }

    public static void main(String[] args) {
        ChinaUtil util = ChinaUtil.getDistrict();
        util.getDistrictNameAll("610104", 3);
    }
}
