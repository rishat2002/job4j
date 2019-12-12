package job4j;

import API.School;
import API.Student;
import org.junit.Test;

import java.util.List;

public class SchoolTest {
    @Test
    public void collectTest() {
        School school1=new School();
        List<Student> firstlist=List.of(new Student(34),new Student(62),new Student(20),new Student(80),new Student(50));
        List<Student>class10C=school1.collect(firstlist,student -> student.getScore()<=50);
        List<Student>class10B=school1.collect(firstlist,student -> student.getScore()>50 && student.getScore()<70);
        List<Student>class10A=school1.collect(firstlist,student -> student.getScore()>=70);
        class10C.forEach(System.out::print);
        System.out.println("");
        class10B.forEach(System.out::print);
        System.out.println("");
        class10A.forEach(System.out::print);
    }
}
