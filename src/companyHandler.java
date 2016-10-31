/**
 * Created by Sanjeev on 10/25/2016.
 */
public class companyHandler {
    public static void main(String args[]){
        Company c = new Company(9);
        c.addEmp(1,2);
        c.addEmp(1,3);
        c.addEmp(1,4);
        c.addEmp(2,5);
        c.addEmp(2,6);
        c.addEmp(2,7);
        c.addEmp(6,8);
        c.addEmp(6,9);

        c.getPaths(1);

    }
}
