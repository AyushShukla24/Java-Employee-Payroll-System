import java.util.*;
abstract class Employee {
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    //getter/setter used to access private varibale
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    //abstract method
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}




class FullTimeEmployee extends Employee{
    
    private double monthlySalary;
    
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }
    
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}



class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,int hourlyRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}



class PayrollSystem{

    private ArrayList<Employee> employeesList;


    public PayrollSystem(){
        employeesList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeesList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }

        if(employeeToRemove!=null){
            employeesList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee:employeesList){
            System.out.println(employee);
        }
    }
}



    public class Main {
        public static void main(String[] args) {
            PayrollSystem payrollSystem=new PayrollSystem();
            FullTimeEmployee emp1=new FullTimeEmployee("Ayush", 1,10000);
            PartTimeEmployee emp2=new PartTimeEmployee("Vinay", 2, 12,700);

            payrollSystem.addEmployee(emp1);
            payrollSystem.addEmployee(emp2);

            System.out.println("Initial Employee Details");
            payrollSystem.displayEmployee();
            System.out.println("Removing Employees");
            payrollSystem.removeEmployee(2);
            System.out.println("Remaing Employee Details");
            payrollSystem.displayEmployee();
        }
    }