package dropdown;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test(dataProvider = "optionData")
    public void testSelectOption(String option) {
        var dropDownPage = homePage.clickDropDown();
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @DataProvider
    public Object[] optionData() {
        Object[] data = new Object[2];

        data[0] = "Option 1";
        data[1] = "Option 2";

        return data;
    }
}
