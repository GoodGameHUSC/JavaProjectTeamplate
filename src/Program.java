import java.util.ArrayList;

import dao.Driver;
import dao.Model;

public class Program {
    public static void main(String[] args) {
        Driver.connect();
        Model.insert();
        
        ArrayList<Object> l = Model.read();
        for (Object object : l) {
            System.out.println(object.toString());
        }
    }
}
