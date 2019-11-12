package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1=new Book();
        Book book2=new Book();
        Book book3=new Book();
        Book book4=new Book();
        book1.setName("Clean code");
        Book[]smallLibrary=new Book[4];
        smallLibrary[0]=book1;
        smallLibrary[1]=book2;
        smallLibrary[2]=book3;
        smallLibrary[3]=book4;
        for (int index=0;index<smallLibrary.length;index++){
            System.out.println(smallLibrary[index].getName()+" "+smallLibrary[index].getCount());
        }
        Book b1=smallLibrary[0];
        smallLibrary[0]=smallLibrary[3];
        smallLibrary[3]=b1;
        for (int i=0;i<smallLibrary.length;i++){
            if(smallLibrary[i].getName()==("Clean code")) {
                System.out.println(smallLibrary[i].getName()+" "+smallLibrary[i].getCount());}
        }
    }
}
