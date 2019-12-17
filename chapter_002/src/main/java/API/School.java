package API;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
     public List<Student> collect(List<Student> students, Predicate<Student> predict) {
         List<Student> sortClass=students.stream().filter(predict).collect(Collectors.toList());
         return sortClass;
     }
    public  List<Student> levelOf(List<Student> students,int bound) {
         List<Student>newlist=students.stream().flatMap(Stream::ofNullable).sorted((s2,s1)-> Integer.compare(s1.getScore(),s2.getScore())).takeWhile(t->t.getScore()>=bound).collect(Collectors.toList());
        return newlist;
    }
    public static void main(String[] args) {
        School scool = new School();
     List<Student>newlist=List.of(new Student("pasha",50),new Student("vova",32),new Student("semen",90));
        System.out.println(scool.levelOf(newlist,52));
    }

}
