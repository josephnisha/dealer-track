package interview;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class UniqueName {

    List<String> getUniqueNameRecords(List<String> records){

        Map<String,Integer> uniqueNameMap = new LinkedHashMap<>();
        if(records == null || records.isEmpty()){
            return null;
        }
        for(String record:records){
            createUniqueRecordsWithSum(uniqueNameMap, record);
        }
        return uniqueNameMap.entrySet().stream().map( x -> x.getKey()+","+x.getValue())
                .collect(Collectors.toList());


    }

    private void createUniqueRecordsWithSum(Map<String, Integer> uniqueNameMap, String record) {
        String[] elements = record.split(",");
        if(elements.length > 1){
            String name = elements[0].toLowerCase();
            try {
                //Assuming non integers are bad records
                int sum = Integer.parseInt(elements[1]);
                Integer existingSum = uniqueNameMap.get(name);
                if(existingSum != null){
                    sum =  sum + existingSum;
                }
                uniqueNameMap.put(name, sum);
            }catch(NumberFormatException nfe){
                logBadRecord(record);
            }
        }else{
            logBadRecord(record);
        }
    }

    private void logBadRecord(String record) {
        System.out.println("Bad Record  : "+ record);
    }

}
