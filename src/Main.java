import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
   @Override
    public double calculateSalary(){
        return monthlySalary;
   }
}
class ParttimeEmployee extends Employee{

    private int hoursWorked;
    private int hourlyRate;
    public ParttimeEmployee(String name,int id,int hourlyRate,int hoursWorked){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
   @Override
    public  double calculateSalary(){
        return hourlyRate*hoursWorked;
    }

}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void  removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id) {
                employeeToRemove = employee;
                break;
                }
            }
        if(employeeToRemove!=null)employeeList.remove(employeeToRemove);
        }
    public void displayEmployee(){
        for(Employee employee:employeeList)
            System.out.println(employee);
    }
}
public class Main {
    public static void main(String[] args) {

    Employee emp1 =new FullTimeEmployee("Rahul",1,40000.0);
    Employee emp2=new ParttimeEmployee("Raj",2,150,4);

    PayrollSystem employePayrlleList = new PayrollSystem();
    employePayrlleList.addEmployee(emp1);
    employePayrlleList.addEmployee(emp2);
    System.out.println("Display the Employee Details");
    employePayrlleList.displayEmployee();
    employePayrlleList.removeEmployee(2);
    System.out.println("Display the Employee Details");
    employePayrlleList.displayEmployee();

    }
}