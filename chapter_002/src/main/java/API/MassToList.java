package API;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MassToList {
    public List<Integer> masToList(Integer[][]mass) {
        List<Integer>list= Arrays.stream(mass).flatMap(Arrays::stream).collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
    }
}
