package API;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
     public List<Student> collect(List<Student> students, Predicate<Student> predict) {
         List<Student> sortClass=students.stream().filter(predict).collect(Collectors.toList());
         return sortClass;
     }

    public static void main(String[] args) {
        Map<String,Student>students=List.of(new Student("Pasha"),new Student("Vlad")).stream().collect(Collectors.toMap(e->e.getSurname(),
                e->e));
        System.out.println(students);
    }

}
