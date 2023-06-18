package Com.Layout;

import Com.Controllers.DataControllers;

public class DeleteDataAction {
    public static void deleteData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.deleteData();
    }
}
