package com.vangbacdaquy.statistics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vangbacdaquy.constant.DatabaseConstant;

import akka.dispatch.japi;

public class StatisticsData {
    public static Map<String, String> objectIdInFile = new HashMap<String, String>();

    public static Map<String, Map<String, Long>> statisticsData(
            String filePath, int columnIndex) throws IOException {
        Map<String, Map<String, Long>> result = new HashMap<String, Map<String, Long>>();

        List<String> lstBreaking = new ArrayList<String>();
        List<String> lstTopic = new ArrayList<String>();
        List<String> lstTimeFactor = new ArrayList<String>();
        List<String> lstBreakingFactor = new ArrayList<String>();

        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell cell = null;
                int index = columnIndex;

                // check blank user
                cell = row.getCell(0);
                if (cell != null && "".equals(cell.getStringCellValue()))
                    break;

                // get Breaking
                cell = row.getCell(index++);
                if (cell != null)
                    lstBreaking
                            .add("".equals(cell.getStringCellValue().trim()) ? "Unlabeled"
                                    : cell.getStringCellValue().trim());

                // get topic
                cell = row.getCell(index++);
                if (cell != null)
                    lstTopic.add("".equals(cell.getStringCellValue().trim()) ? "Unlabeled"
                            : cell.getStringCellValue().trim());

                // get timeFactor
                cell = row.getCell(index++);
                if (cell != null)
                    lstTimeFactor.add("".equals(cell.getStringCellValue()
                            .trim()) ? "Unlabeled" : cell.getStringCellValue()
                            .trim());

                // get breakingFactor
                cell = row.getCell(index);
                if (cell != null)
                    lstBreakingFactor.add("".equals(cell.getStringCellValue()
                            .trim()) ? "Unlabeled" : cell.getStringCellValue()
                            .trim());

            }

            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // group by breaking and count
        Map<String, Long> groupByBreaking = lstBreaking.stream().collect(
                Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        // group by breaking and count
        Map<String, Long> groupByTopic = lstTopic.stream().collect(
                Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        // group by breaking and count
        Map<String, Long> groupByTimeFactor = lstTimeFactor.stream().collect(
                Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        // group by breaking and count
        Map<String, Long> groupByBreakingFactor = lstBreakingFactor.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));

        result.put("Breaking", groupByBreaking);
        result.put("Topic", groupByTopic);
        result.put("TimeFactor", groupByTimeFactor);
        result.put("BreakingFactor", groupByBreakingFactor);
        return result;
    }

    public static Map<String, Map<String, Long>> statisticsByTopc(
            String filePath, int columnTopic, int columnGroupBy)
            throws IOException {
        Map<String, Map<String, Long>> result = new HashMap<String, Map<String, Long>>();

        List<String> lstContent = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell cell = null;
                int index = columnTopic;

                // check user blank
                cell = row.getCell(0);
                if (cell != null && "".equals(cell.getStringCellValue().trim()))
                    break;

                // get topic
                cell = row.getCell(columnTopic);
                if (cell != null) {
                    Cell c = row.getCell(columnGroupBy);
                    if (c != null) {
                        if (map.containsKey(cell.getStringCellValue().trim())) {
                            map.get(cell.getStringCellValue().trim()).add(
                                    c.getStringCellValue().trim());
                        } else {
                            List<String> lst = new ArrayList<String>();
                            lst.add(c.getStringCellValue().trim());
                            map.put(cell.getStringCellValue().trim(), lst);
                        }
                    }

                }

            }

            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (String s : map.keySet()) {
            Map<String, Long> grouping = map
                    .get(s)
                    .stream()
                    .collect(
                            Collectors.groupingBy(Function.identity(),
                                    Collectors.counting()));
            result.put(s, grouping);
        }
        return result;
    }

    public static Map<String, List<String>> statisticsGroupBy(String filePath,
            int columnTopic, int columnGroupBy) throws IOException {
        Map<String, List<String>> result = new HashMap<String, List<String>>();

        List<String> lstContent = new ArrayList<String>();

        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell cell = null;
                int index = columnTopic;

                // check user blank
                cell = row.getCell(0);
                if (cell != null && "".equals(cell.getStringCellValue().trim()))
                    break;

                // get topic
                cell = row.getCell(columnTopic);
                if (cell != null) {
                    Cell c = row.getCell(columnGroupBy);
                    if (c != null) {
                        String value = cell.getStringCellValue().trim();
                        if (value.contains("Act of War or Violence")) {
                            value = "Act of War or Violence, Military News";
                        }
                        if (value.contains("Political Meeting")) {
                            value = "Political Meeting and Statement";
                        }
                        if (result
                                .containsKey("".equals(value) ? "Chưa gán chủ đề"
                                        : value)) {
                            result.get(
                                    "".equals(value) ? "Chưa gán chủ đề"
                                            : value)
                                    .add("".equals(c.getStringCellValue()
                                            .trim()) ? "chưa gán" : c
                                            .getStringCellValue().trim());
                        } else {
                            List<String> lst = new ArrayList<String>();
                            lst.add("".equals(c.getStringCellValue().trim()) ? "chưa gán"
                                    : c.getStringCellValue().trim());
                            result.put("".equals(value) ? "Chưa gán chủ đề"
                                    : value, lst);
                        }
                    }
                }

            }

            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    // đọc 1 file Excel
    public static Map<String, String> readFile(String filePath)
            throws IOException {
        Map<String, String> result = new HashMap<String, String>();
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell cell = null;

                // check user blank
                cell = row.getCell(0);
                if (cell != null && "".equals(cell.getStringCellValue().trim()))
                    break;

                // get ObjectID
                cell = row.getCell(0);
                if (cell != null) {
                    // get breaking value
                    Cell cBreaking = row.getCell(7);
                    // get topic value
                    Cell cTopic = row.getCell(8);

                    String breakingTopic = "";
                    if (cBreaking != null && cTopic != null) {
                        String breaking = "".equals(cBreaking
                                .getStringCellValue().trim()) ? "" : cBreaking
                                .getStringCellValue().trim();
                        String topic = "".equals(cTopic.getStringCellValue()
                                .trim()) ? "" : cTopic.getStringCellValue()
                                .trim();
                        breakingTopic = breaking + " " + topic;

                    }

                    result.put(cell.getStringCellValue(), breakingTopic);
                }

            }

            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // Đọc 1 thự mục nhiều file
    public static Map<String, String> readFolder(String folderPath)
            throws IOException {
        Map<String, String> result = new HashMap<String, String>();
        File[] files = new File(folderPath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory() && !file.isHidden() && file.exists()) {
                    Map<String, String> temp = new HashMap<String, String>();
                    temp = StatisticsData.readFile(file.getAbsolutePath());
                    result.putAll(temp);
                }
            }
        }
        return result;
    }

    // đọc 1 file Excel
    public static Map<String, Row> readFilePath(String filePath)
            throws IOException {
        Map<String, Row> result = new HashMap<String, Row>();
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell cell = null;

                // check user blank
                cell = row.getCell(0);
                if (cell != null && "".equals(cell.getStringCellValue().trim()))
                    break;

                // get ObjectID
                cell = row.getCell(0);
                if (cell != null) {
                    String label = "";
                    Cell c = row.getCell(7); // lay cot breaking label de trim
                    if (c != null) {
                        label = c.getStringCellValue().trim();
                    }
                    c.setCellValue(label);

                    // check null && blank content

                    if (row.getCell(4) == null
                            || row.getCell(4).getCellType() == Cell.CELL_TYPE_BLANK) {
                        row.getCell(4).setCellValue("");
                    }
                    result.put(cell.getStringCellValue(), row);
                }

            }

            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // Đọc 1 thự mục nhiều file
    public static Map<String, Row> readFolderPath(String folderPath)
            throws IOException {
        Map<String, Row> result = new HashMap<String, Row>();
        File[] files = new File(folderPath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory() && !file.isHidden() && file.exists()) {
                    Map<String, Row> temp = new HashMap<String, Row>();
                    temp = StatisticsData.readFilePath(file.getAbsolutePath());

                    for (String key : temp.keySet()) {
                        objectIdInFile.put(key, file.getName());
                    }
                    result.putAll(temp);
                }
            }
        }
        return result;
    }

    public static <K> Map<K, Long> mergeAndAdd(Map<K, Long>... maps) {
        Map<K, Long> result = new HashMap<>();
        for (Map<K, Long> map : maps) {
            for (Map.Entry<K, Long> entry : map.entrySet()) {
                K key = entry.getKey();
                Long current = result.get(key);
                result.put(key,
                        current == null ? entry.getValue() : entry.getValue()
                                + current);
            }
        }
        return result;
    }

    public static <K> Map<K, List<String>> merge(Map<K, List<String>>... maps) {
        Map<K, List<String>> result = new HashMap<>();
        for (Map<K, List<String>> map : maps) {
            for (Map.Entry<K, List<String>> entry : map.entrySet()) {
                K key = entry.getKey();
                List<String> addAll = new ArrayList<String>();
                List<String> current = result.get(key);
                if (current != null)
                    addAll.addAll(current);
                addAll.addAll(entry.getValue());
                result.put(key, current == null ? entry.getValue() : addAll);
            }
        }
        return result;
    }

    public static Long sum(Map<String, Long> map) {
        Long sum = 0l;
        for (String s : map.keySet()) {
            sum += map.get(s);
        }
        return sum;
    }

    public static String getValueRow(Row row, int column) {
        String value = "";
        Cell cell = row.getCell(column);
        if (cell != null) {
            value = "".equals(cell.getStringCellValue().trim()) ? "" : cell
                    .getStringCellValue().trim();
        }
        return value;
    }

    public static void writeFileExcel(List<Row> lstRow, String outFilePath)
            throws FileNotFoundException, IOException {
        XSSFWorkbook wBook = new XSSFWorkbook();
        XSSFSheet sheet = wBook.createSheet();
        Row row = sheet.createRow(0);

        // first line in excel file: column names
        int i = 0;
        for (String header : DatabaseConstant.ExcelHeader) {
            row.createCell(i).setCellValue(header);
            i++;
        }

        int rowIndex = 1;
        for (Row r : lstRow) {
            row = sheet.createRow(rowIndex);
            int cellIndex = 0;
            for (int j = 0; j < 9; j++) {
                String value = r.getCell(j) == null ? "" : r.getCell(j)
                        .getStringCellValue().trim();
                row.createCell(cellIndex).setCellValue(value);
                cellIndex++;
            }
            row.createCell(9).setCellValue(
                    objectIdInFile.get(r.getCell(0).getStringCellValue()));
            rowIndex++;
        }

        File newFile = new File(outFilePath);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        wBook.write(new FileOutputStream(newFile));
        wBook.close();
    }

    public static void writeFileExcel(List<Row> lstRow, String outFilePath,
            int numberColumn) throws FileNotFoundException, IOException {
        XSSFWorkbook wBook = new XSSFWorkbook();
        XSSFSheet sheet = wBook.createSheet();
        Row row = sheet.createRow(0);

        // first line in excel file: column names
        int i = 0;
        for (String header : DatabaseConstant.Header) {
            row.createCell(i).setCellValue(header);
            i++;
        }

        int rowIndex = 1;
        for (Row r : lstRow) {
            row = sheet.createRow(rowIndex);
            int cellIndex = 0;
            for (int j = 0; j <= numberColumn; j++) {
                String value = r.getCell(j) == null ? "" : r.getCell(j)
                        .getStringCellValue().trim();
                row.createCell(cellIndex).setCellValue(value);
                cellIndex++;
            }
            int num = numberColumn + 1;
            row.createCell(num).setCellValue(
                    objectIdInFile.get(r.getCell(0).getStringCellValue()));
            rowIndex++;
        }
        File newFile = new File(outFilePath);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        wBook.write(new FileOutputStream(newFile));
        wBook.close();
    }

    public static String renameTopic(String value) {
        if (value.contains("Act of War or Violence")) {
            return "Act of War or Violence, Military News";
        }
        if (value.contains("Political Meeting")) {
            return "Political Meeting and Statement";
        }
        return value;
    }

    /**
     * 
     * @param folderPath1
     *            (thư mực chứa các file gán nhãn của bạn đầu tiên)
     * @param folderPath2
     *            (thư mực chứa các file gán nhãn của bạn thứ 2)
     * @param folderPath3
     *            (thư mực chứa các file gán nhãn của bạn thứ 3)
     * @outPut: tại thư mục resource (System.getProperty("user.dir") +
     *          File.separator + "resource" + File.separator)
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void statisticLabeledResult(String folderPath1,
            String folderPath2, String folderPath3)
            throws FileNotFoundException, IOException {
        Long start = System.currentTimeMillis();
        Map<String, Row> anLK = StatisticsData.readFolderPath(folderPath1);
        Map<String, Row> huongHT = StatisticsData.readFolderPath(folderPath2);
        Map<String, Row> giangNH = StatisticsData.readFolderPath(folderPath2);
        List<Row> listOfSimilarRow = new ArrayList<Row>();
        List<Row> listOfDifferentRow = new ArrayList<Row>();

        int count = 0;
        int dem = 0;
        for (String key : huongHT.keySet()) {
            if (giangNH.containsKey(key) && anLK.containsKey(key)) {
                String brTpHuongHT = StatisticsData.getValueRow(
                        huongHT.get(key), 7)
                        + "-"
                        + renameTopic(StatisticsData.getValueRow(
                                huongHT.get(key), 8));
                String brTpGiangNH = StatisticsData.getValueRow(
                        giangNH.get(key), 7)
                        + "-"
                        + renameTopic(StatisticsData.getValueRow(
                                giangNH.get(key), 8));
                String brTpAnLK = StatisticsData.getValueRow(anLK.get(key), 7)
                        + "-"
                        + renameTopic(StatisticsData.getValueRow(anLK.get(key),
                                8));

                if (brTpHuongHT.equals(brTpGiangNH)
                        && brTpHuongHT.equals(brTpAnLK)) {
                    count++;
                    listOfSimilarRow.add(huongHT.get(key));
                } else {
                    dem++;
                    Row row = huongHT.get(key);
                    // thêm giá trị cột breaking của an
                    row.createCell(9).setCellValue(
                            StatisticsData.getValueRow(anLK.get(key), 7));
                    // thêm giá trị cột topic của an
                    row.createCell(10).setCellValue(
                            renameTopic(StatisticsData.getValueRow(
                                    anLK.get(key), 8)));
                    // thêm giá trị cột breaking của giang
                    row.createCell(11).setCellValue(
                            StatisticsData.getValueRow(giangNH.get(key), 7));
                    // thêm giá trị cột topic của giang
                    row.createCell(12).setCellValue(
                            renameTopic(StatisticsData.getValueRow(
                                    giangNH.get(key), 8)));

                    listOfDifferentRow.add(row);
                }
            }
        }
        String outPutFolder = System.getProperty("user.dir") + File.separator
                + "resource" + File.separator;
        StatisticsData.writeFileExcel(listOfSimilarRow, outPutFolder
                + "The_Same_Results.xlsx");
        StatisticsData.writeFileExcel(listOfDifferentRow, outPutFolder
                + "The_Different_Results.xlsx", 12);
        System.out.println("Total time: "
                + (System.currentTimeMillis() - start));
        System.out.println("Số lượng đồng thuận là: " + count);
        System.out.println("Số lượng không đồng thuận là: " + dem);
        System.out.println("tổng số lượng: " + (count + dem));
    }

    public static void statisticResultFromFile(String filePath) {
        List<Map<String, Map<String, Long>>> list = new ArrayList<Map<String, Map<String, Long>>>();
        Map<String, Map<String, Long>> total = new HashMap<String, Map<String, Long>>();

        List<Map<String, List<String>>> lst = new ArrayList<Map<String, List<String>>>();
        Map<String, List<String>> to = new HashMap<String, List<String>>();

        long start = System.currentTimeMillis();
        File[] files = new File(filePath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory() && !file.isHidden() && file.exists()) {
                    Map<String, Map<String, Long>> temp = null;
                    Map<String, List<String>> test = null;
                    try {
                        // temp =
                        // StatisticsData.statisticsData(file.getAbsolutePath(),
                        // 7);
                        test = StatisticsData.statisticsGroupBy(
                                file.getAbsolutePath(), 8, 7);
                        // System.out.println(test);
                        // list.add(temp);
                        lst.add(test);
                        // temp =
                        // StatisticsData.statisticsByTopc(file.getAbsolutePath(),
                        // 8, 7);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }

            to = lst.get(0);
            for (int i = 1; i < lst.size(); i++) {
                to = merge(to, lst.get(i));
            }

            Map<String, Map<String, Long>> lstStrMap = new HashMap<String, Map<String, Long>>();
            for (String s : to.keySet()) {
                Map<String, Long> sl = new HashMap<String, Long>();
                sl = to.get(s)
                        .stream()
                        .collect(
                                Collectors.groupingBy(Function.identity(),
                                        Collectors.counting()));
                lstStrMap.put(s, sl);
            }

            // tính tổng số lượng dòng tweet trong tất cả các file.
            Long sumOfTweet = 0L;
            for (String s : lstStrMap.keySet()) {
                sumOfTweet += sum(lstStrMap.get(s));
            }
            // in dữ liệu thống kê
            System.out.println("THỐNG KÊ THEO CHỦ ĐỀ");
            System.out.println("TỔNG SỐ LƯỢNG TIN : " + sumOfTweet);
            System.out.println("-----------------------");
            for (String s : lstStrMap.keySet()) {
                System.out.println(s + " : " + sum(lstStrMap.get(s)) + " tin");
                for (String ss : lstStrMap.get(s).keySet()) {
                    System.out.println("\t Nhãn " + ss + " : "
                            + lstStrMap.get(s).get(ss) + " tin");
                }
            }

        }
    }

    // lấy theo cột topic và group by breaking
    public static void statisticsFromTheSameResultFile(String inputFile,
            String outputDir) throws IOException, InvalidFormatException {

        List<String> lstContent = new ArrayList<String>();
        // chua row tuong ung voi topicLabel
        Map<TopicLabel, List<Row>> result = new HashMap<TopicLabel, List<Row>>();

        int topicColumnIndex = 8;
        int labelColumnIndex = 7;
        String topic = "";
        String label = "";
        try {
            FileInputStream excelFile = new FileInputStream(inputFile);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row;
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // check ObjectID blank
                if (row.getCell(0) != null
                        && "".equals(row.getCell(0).getStringCellValue().trim()))
                    break;

                // get label
                Cell labelCell = row.getCell(labelColumnIndex);

                if (labelCell != null
                        && !"".equals(labelCell.getStringCellValue().trim())) {
                    Cell topicCell = row.getCell(topicColumnIndex);
                    if (labelCell.getStringCellValue().trim()
                            .equals("Không liên quan"))
                        topicCell.setCellValue("Chưa gán chủ đề");
                    else if (topicCell != null
                            && "".equals(topicCell.getStringCellValue().trim())) {
                        System.out.println("objectid nhãn lỗi :"
                                + row.getCell(0).getStringCellValue());
                        break; // vì nếu thuộc nhãn yes hoặc không thì phải có
                               // nhãn
                    }
                    topic = topicCell.getStringCellValue().trim();
                    label = labelCell.getStringCellValue().trim();
                    TopicLabel mapKey = new TopicLabel(topic, label);
                    List<Row> listRow = result.get(mapKey);
                    if (listRow == null) {
                        // topicLabel key chua co
                        listRow = new ArrayList<Row>();
                        listRow.add(row);
                    } else
                        listRow.add(row);
                    // put lai row vao map
                    result.put(mapKey, listRow);
                }
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Ghi du lieu tu result map vao file
        for (Map.Entry<TopicLabel, List<Row>> entry : result.entrySet()) {
            TopicLabel topicLabel = entry.getKey();
            String outputFilePath = outputDir + File.separator
                    + topicLabel.toString() + ".xlsx";
            System.out.println("writing file: " + outputFilePath);
            XSSFWorkbook wBook = new XSSFWorkbook();
            XSSFSheet sheet = wBook.createSheet();
            Row row = sheet.createRow(0);

            // first line in excel file: column names
            int i = 0;
            for (String header : DatabaseConstant.ExcelHeader) {
                row.createCell(i).setCellValue(header);
                i++;
            }

            int rowIndex = 1;
            List<Row> lstRow = entry.getValue();
            for (Row r : lstRow) {
                row = sheet.createRow(rowIndex);
                int cellIndex = 0;
                for (int j = 0; j < 10; j++) {
                    String value = r.getCell(j) == null ? "" : r.getCell(j)
                            .getStringCellValue();
                    row.createCell(cellIndex).setCellValue(value);
                    cellIndex++;
                }
                // row.createCell(9).setCellValue(objectIdInFile.get(r.getCell(0).getStringCellValue()));
                rowIndex++;
            }

            File newFile = new File(outputFilePath);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            wBook.write(new FileOutputStream(newFile));
            wBook.close();
        }

        statisticsFromTheSameResultFileByTopic(outputDir, 0);
        statisticsFromTheSameResultFileByTopic(outputDir, 1);

    }

    public static void statisticsFromTheSameResultFileByTopic(
            String inputFolder, int index) throws InvalidFormatException,
            IOException {
        File[] files = new File(inputFolder).listFiles();
        Map<String, String> mapNames = new HashMap<String, String>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory() && !files[i].isHidden()
                        && files[i].exists()) {
                    String filename = files[i].getName().split("_")[index];
                    // != null, tức là đã xử lý rồi
                    if (mapNames.get(filename) != null)
                        continue;
                    System.out.println("writting: " + inputFolder
                            + File.separator + index + File.separator
                            + filename + ".xlsx");
                    mapNames.put(filename, filename);
                    XSSFWorkbook wBookI = new XSSFWorkbook(new File(
                            files[i].getPath()));

                    XSSFWorkbook workbookResult = new XSSFWorkbook();
                    XSSFSheet sheetResult = workbookResult.createSheet();
                    Row rowResult = sheetResult.createRow(0);
                    Row rowI;
                    Iterator<Row> rowIterator = wBookI.getSheetAt(0).iterator();
                    rowI = rowIterator.next();
                    int lastRow = 0;
                    for (String header : DatabaseConstant.ExcelHeader) {
                        rowResult.createCell(lastRow).setCellValue(header);
                        lastRow++;
                    }
                    // ghi workBookI vào workBookResult
                    lastRow = 1;
                    while (rowIterator.hasNext()) {
                        rowI = rowIterator.next();// check ObjectID blank
                        rowResult = sheetResult.createRow(lastRow);
                        if (rowI.getCell(0) != null
                                && "".equals(rowI.getCell(0)
                                        .getStringCellValue().trim()))
                            break;
                        int cellIndex = 0;
                        for (int cellIter = 0; cellIter < 10; cellIter++) {
                            String value = rowI.getCell(cellIter) == null ? ""
                                    : rowI.getCell(cellIter)
                                            .getStringCellValue();
                            rowResult.createCell(cellIndex).setCellValue(value);
                            cellIndex++;
                        }
                        lastRow++;
                    }
                    for (int j = i + 1; j < files.length; j++) {
                        if (!files[j].isDirectory() && !files[j].isHidden()
                                && files[j].exists()) {
                            String innerFileName = files[j].getName()
                                    .split("_")[index];

                            if (!filename.equals(innerFileName))
                                continue;
                            sheetResult = workbookResult.getSheetAt(0);
                            XSSFWorkbook wBookJ = new XSSFWorkbook(new File(
                                    files[j].getPath()));
                            // lay row cuoi cung trong sheet i
                            lastRow = 0;
                            Iterator<Row> rowResultterator = workbookResult
                                    .getSheetAt(0).iterator();
                            rowResult = rowResultterator.next();
                            while (rowResultterator.hasNext()) {
                                rowResult = rowResultterator.next();// check
                                                                    // ObjectID
                                                                    // blank
                                if (rowResult.getCell(0) != null
                                        && "".equals(rowResult.getCell(0)
                                                .getStringCellValue().trim()))
                                    break;
                                lastRow++;
                            }
                            lastRow++;
                            // duyet qua cac row cua j de append vao i
                            Row rowJ;
                            Iterator<Row> rowJterator = wBookJ.getSheetAt(0)
                                    .iterator();
                            rowJ = rowJterator.next();
                            while (rowJterator.hasNext()) {
                                rowJ = rowJterator.next();
                                rowResult = sheetResult.createRow(lastRow);
                                if (rowResult.getCell(0) != null
                                        && "".equals(rowResult.getCell(0)
                                                .getStringCellValue().trim()))
                                    break;
                                int cellIndex = 0;
                                for (int cellIter = 0; cellIter < 10; cellIter++) {
                                    String value = rowJ.getCell(cellIter) == null ? ""
                                            : rowJ.getCell(cellIter)
                                                    .getStringCellValue();
                                    rowResult.createCell(cellIndex)
                                            .setCellValue(value);
                                    cellIndex++;
                                }
                                // row.createCell(9).setCellValue(objectIdInFile.get(r.getCell(0).getStringCellValue()));
                                lastRow++;

                            }
                            wBookJ.close();
                        }
                    }
                    // hoàn tất việc tạo file. ghi file
                    File newFile = new File(inputFolder + File.separator
                            + index + File.separator + filename + ".xlsx");
                    if (!newFile.getParentFile().exists()) {
                        newFile.getParentFile().mkdirs();
                    }
                    workbookResult.write(new FileOutputStream(newFile));
                    wBookI.close();
                    workbookResult.close();

                }
            }
        }
    }

    /**
     * Đếm số lượng dòng trong mỗi file chủ đề
     * 
     * @param folderPath
     * @return
     * @throws IOException
     */
    public static Map<String, Long> countRecordNumberInSingleFile(
            String folderPath) throws IOException {
        Map<String, Long> result = new HashMap<String, Long>();
        File[] files = new File(folderPath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory() && !file.isHidden() && file.exists()) {
                    String fileName = file.getName();
                    String topic = renameTopic(fileName.substring(0,
                            fileName.length() - 5));
                    // số lượng record trong file
                    Long recordNumber = 0L;
                    try {
                        FileInputStream excelFile = new FileInputStream(
                                file.getAbsolutePath());
                        Workbook workbook = new XSSFWorkbook(excelFile);
                        Sheet sheet = workbook.getSheetAt(0);

                        Row row;
                        Iterator<Row> rowIterator = sheet.iterator();

                        // bỏ qua dòng header
                        row = rowIterator.next();

                        while (rowIterator.hasNext()) {
                            row = rowIterator.next();
                            // check blank user
                            Cell cell = row.getCell(0);
                            if (cell != null
                                    && "".equals(cell.getStringCellValue()))
                                break;

                            recordNumber++;
                        }

                        workbook.close();
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    result.put(topic, recordNumber);
                }
            }
        }

        return result;

    }

    public static Map<String, Map<String, Long>> statisticResultFromFileV2(
            String filePath) {

        List<Map<String, List<String>>> lst = new ArrayList<Map<String, List<String>>>();
        Map<String, List<String>> to = new HashMap<String, List<String>>();
        Map<String, Map<String, Long>> lstStrMap = new HashMap<String, Map<String, Long>>();

        File[] files = new File(filePath).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory() && !file.isHidden() && file.exists()) {
                    Map<String, Map<String, Long>> temp = null;
                    Map<String, List<String>> test = null;
                    try {
                        test = StatisticsData.statisticsGroupBy(
                                file.getAbsolutePath(), 8, 7);
                        lst.add(test);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
            to = lst.get(0);
            for (int i = 1; i < lst.size(); i++) {
                to = merge(to, lst.get(i));
            }

            for (String s : to.keySet()) {
                Map<String, Long> sl = new HashMap<String, Long>();
                sl = to.get(s)
                        .stream()
                        .collect(
                                Collectors.groupingBy(Function.identity(),
                                        Collectors.counting()));
                lstStrMap.put(s, sl);
            }
        }
        return lstStrMap;
    }

    /**
     * 
     * @param folderPath1
     *            : folder chứa các file dữ liệu đã lấy về từ twitter (chưa gán
     *            nhãn)
     * @param folderPath2
     *            : folder chứ file dữ liệu đã đồng thuận (đã gán nhãn)
     * @param outFilePath
     *            : folder output file kết quả thống kê
     * @throws IOException
     */
    public static void compareTopicCountBeforeAndAfterLabeling(
            String folderPath1, String folderPath2, String outFilePath)
            throws IOException {
        // Số lượng tweet theo mỗi chủ đề lấy về (chưa gán nhãn)
        Map<String, Long> tweetCountEachCategory = StatisticsData
                .countRecordNumberInSingleFile(folderPath1);

        // Số lượng yes/no/klq theo mỗi chủ đề (file đồng thuận - đã gán nh
        Map<String, Map<String, Long>> breakingGroupByTopic = StatisticsData
                .statisticResultFromFileV2(folderPath2);

        for (String key : breakingGroupByTopic.keySet()) {
            Map<String, Long> breakingMap = breakingGroupByTopic.get(key);
            Long tweetCount = tweetCountEachCategory.get(key);
            breakingMap.put("Số lượng tweet lấy về", tweetCount == null ? 0
                    : tweetCount);
            if (!breakingMap.containsKey("Có")) {
                breakingMap.put("Có", 0L);
            }
            if (!breakingMap.containsKey("Không")) {
                breakingMap.put("Không", 0L);
            }
            if (!breakingMap.containsKey("Không liên quan")) {
                breakingMap.put("Không liên quan", 0L);
            }
        }

        XSSFWorkbook wBook = new XSSFWorkbook();
        XSSFSheet sheet = wBook.createSheet();
        Row row = sheet.createRow(0);

        // first line in excel file: column names
        int i = 0;
        List<String> headers = Arrays.asList("Chủ đề", "Có", "Không",
                "Không liên quan", "Số lượng tweet lấy về");
        for (String header : headers) {
            row.createCell(i).setCellValue(header);
            i++;
        }

        int rowIndex = 1;
        for (String key : breakingGroupByTopic.keySet()) {
            row = sheet.createRow(rowIndex);
            Map<String, Long> breakingMap = breakingGroupByTopic.get(key);
            row.createCell(0).setCellValue(key);
            int cellIndex = 1;
            for (String s : breakingMap.keySet()) {
                Long value = breakingMap.get(s);
                row.createCell(cellIndex).setCellValue(value);
                cellIndex++;
            }
            rowIndex++;
        }

        File newFile = new File(outFilePath);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        wBook.write(new FileOutputStream(newFile));
        wBook.close();
    }

    public static void main(String[] args) throws IOException,
            InvalidFormatException {
        // Phan tich du lieu gan nhan cua 3 ban cho ra 2 tap file dong thuan va
        // khong dong thuan
        // @outPut: tại thư mục resource (System.getProperty("user.dir") +
        // "/resource/") gồm 2 file Excel, đồng thuận và không đồng thuận
        /*
         * String folderPath1 =
         * "/home/itsudo/1. Members/AnLK/LabelData/Twitter_VN"; String
         * folderPath2 = "/home/itsudo/1. Members/GiangNH/LabelData/Twitter_VN";
         * String folderPath3 =
         * "/home/itsudo/1. Members/HuongHT/LabelData/Twitter_VN";
         */
        System.out.println("starting.....");
        String resource = System.getProperty("user.dir") + File.separator
                + "resource";
        String inputFile = resource + File.separator + "The_Same_Results.xlsx";
        String outputFolder = resource + File.separator + "statistics";
        StatisticsData.statisticsFromTheSameResultFile(inputFile, outputFolder);

        System.out.println("done....");
        // statisticLabeledResult(folderPath1, folderPath2, folderPath3);

        // Thong ke du lieu gan nhan co bao nhieu tin nong, khong nong, khong
        // lien quan theo moi chu de
        // System.out.println("----------------------------------------------");
        // StatisticsData.statisticResultFromFile("/home/itsudo/1.
        // Members/Dong_Thuan");
    }
}

class TopicLabel {
    public String topic;

    public String label;

    public TopicLabel(String topic, String label) {
        // TODO Auto-generated constructor stub
        this.label = label;
        this.topic = topic;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return topic + "_" + label;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TopicLabel other = (TopicLabel) obj;
        if (topic.equals(other.topic) && label.equals(other.label))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return topic.hashCode() + label.hashCode();
    }
}
