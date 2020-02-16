package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class INandOut {
    private List<Operations> functional;

    public INandOut(List<Operations> functional) {
        this.functional = functional;
    }
   public void mainMethod() {
      Double result=0.0;
        String personInput=" ";
        while (!personInput.equals(Integer.toString(functional.size()+1))) {
            this.menu();
           Scanner in=new Scanner(System.in);
           personInput=in.nextLine();
           for (int i=0;i<functional.size();i++) {
               if(personInput.equals(Integer.toString(i))){
               System.out.println("Введите данные:");
               if (result==0) {
                   result=in.nextDouble();
               }
               result = functional.get(i).operation(result, in.nextDouble());
               System.out.println(result);}
           }
        if (personInput.equals(Integer.toString(functional.size()))) {
        result=0.0;
        }
        else if (personInput.equals(Integer.toString(functional.size()+1))) {
            return;
        }
       }
    }
    public void menu() {
        int index=0;
        System.out.println("Выберите операцию:");
        for (Operations oper:this.functional) {
            System.out.println(index+". "+oper.getOperationName());
            index++;
        }
        System.out.println(index+" .Стереть данные");
        System.out.println((index+1)+". Закончить вычисления");
    }

    public static void main(String[] args) {
        List<Operations>list=new ArrayList<>();
        list.add(new Plus());
        list.add(new Minus());
        list.add(new Multiply());
        list.add(new Division());
        list.add(new Sin());
        list.add(new Cos());
        list.add(new Tang());
        INandOut i=new INandOut(list);
        i.mainMethod();
    }
}
