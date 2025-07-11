package Contratos.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;

    private Departament departament;
    private List<Contract> contracts = new ArrayList<>();


    public Worker(Departament departament, String name, WorkerLevel level, double baseSalary ) {
        this.departament = departament;
        this.level = level;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public void addContract (Contract contract){
        contracts.add(contract);
    }

    public void removeContract (Contract contract){
        contracts.remove(contract);
    }

    public Double income (Integer year, Integer month){
        Double total = baseSalary;
        for(Contract contract : contracts){
            LocalDate date = contract.getDate();
            if(year == date.getYear() && month == date.getMonthValue()){
                total += contract.totalValue();
            }
        }
        return total;
    }
}
