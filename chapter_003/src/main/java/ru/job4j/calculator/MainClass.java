package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    private List<Input> operations;

    public MainClass(List<Input> operations) {
        this.operations = operations;
    }
    public void menu() {
        int index=0;
        System.out.println("Выберите операцию:");
        for (Input oper:this.operations) {
            System.out.println(index+". "+oper.getOperationName());
            index++;
        }
        System.out.println(index+" .Стереть данные");
        System.out.println((index+1)+". Закончить вычисления");
    }
    public void mainMethod() {
        Calculate calc=new Calculate();
        Double result=0.0;
        String personInput=" ";
        while (!personInput.equals(Integer.toString(operations.size()+1))) {
            this.menu();
            Scanner in=new Scanner(System.in);
            personInput=in.nextLine();
            for (int i=0;i<operations.size();i++) {
                if(personInput.equals(Integer.toString(i))){
                    result = operations.get(i).execute(calc, result);
                    }
            }
            if (personInput.equals(Integer.toString(operations.size()))) {
                result=0.0;
            }
            else if (personInput.equals(Integer.toString(operations.size()+1))) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        MinusInput in1=new MinusInput();
        PlusInput in2=new PlusInput();
        CosInput in3=new CosInput();
        List<Input>l=new ArrayList<Input>();
        l.add(in1);
        l.add(in2);
        l.add(in3);
        MainClass m=new MainClass(l);
        m.mainMethod();
    }
}
