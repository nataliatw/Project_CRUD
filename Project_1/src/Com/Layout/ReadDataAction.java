package Com.Layout;

import Com.Controllers.DataControllers;

public class ReadDataAction {
    public static void readData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.getDatabase();
    }
}
