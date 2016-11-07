package interview;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class UniqueName {

    List<String> getUniqueNameRecords(List<String> records){

        Map<String, BigDecimal> uniqueNameMap = new LinkedHashMap<>();
        if(records == null || records.isEmpty()){
            return null;
        }
        for(String record:records){
            createUniqueRecordsWithSum(uniqueNameMap, record);
        }
        return uniqueNameMap.entrySet().stream().map( x -> x.getKey()+","+x.getValue())
                .collect(Collectors.toList());


    }

    private void createUniqueRecordsWithSum(Map<String, BigDecimal> uniqueNameMap, String record) {
        String[] elements = record.split(",");
        boolean validRecord = false;
        if(elements.length > 1){
            String name = elements[0].toLowerCase();

            //Assuming non numbers are bad records
            String number = elements[1];
            if (isNumber(number)) {
                //assumption here is we expect big numbers and/or too many records
                //that integer may not be big enough to handle
                BigDecimal sum = new BigDecimal(number);
                BigDecimal existingSum = uniqueNameMap.get(name);
                if (existingSum != null) {
                    sum = sum.add(existingSum);
                }
                uniqueNameMap.put(name, sum);
                validRecord = true;
            }
        }
        if (!validRecord) {
            logBadRecord(record);
        }
    }

    private void logBadRecord(String record) {
        System.out.println("Bad Record  : "+ record);
    }

    boolean isNumber(String text) {
        return text.matches("-?\\d+(\\.\\d+)?");
    }

}
