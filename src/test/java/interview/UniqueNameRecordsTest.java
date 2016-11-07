package interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UniqueNameRecordsTest {
    @Test
    public void getUniqueNameRecords() {

        List<String> records = new ArrayList<>();
        records.add("Bob,3");
        records.add("sally,3");
        records.add("bob,1");
        records.add("KG,3");
        records.add("Doug,1");
        records.add("Doudg,1344333333355677777");
        records.add("KG,4");

        UniqueName uniqueName = new UniqueName();
        List<String> uniqueNameRecords = uniqueName.getUniqueNameRecords(records);
        Assert.assertEquals("bob,4",uniqueNameRecords.get(0));
        Assert.assertEquals("sally,3",uniqueNameRecords.get(1));
        Assert.assertEquals("kg,7",uniqueNameRecords.get(2));
        Assert.assertEquals("doug,1",uniqueNameRecords.get(3));
    }

}