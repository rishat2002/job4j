package test.java;

import org.junit.Test;
import tdd.Generator;
import tdd.GeneratorString;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {
    @Test
    public void produceTest() {
        Generator gen=new GeneratorString();
        Map<String,String>map=new HashMap<>();
        map.put("name","ivan");
        map.put("subject","savelev");
        String result=gen.produce("I am a ${name}, Who are ${subject}? ",map);
        assertThat("I am a ivan savelev, Who are you? ", is(result));
    }
    @Test(expected = Exception.class)
    public void produceWithUselessKeysTest() {
        Generator gen=new GeneratorString();
        Map<String,String>map=new HashMap<>();
        map.put("name","ivan");
        map.put("subject","savelev");
        map.put("scolov","rit");
        String result=gen.produce("I am a ${name}, Who are ${subject}? ",map);
        assertThat("I am a ivan savelev, Who are you? ", is(result));
    }
    @Test(expected = Exception.class)
    public void produceNotEnoughKeysTest() {
        Generator gen=new GeneratorString();
        Map<String,String>map=new HashMap<>();
        map.put("name","ivan");
        String result=gen.produce("I am a ${name}, Who are ${subject}? ",map);
        assertThat("I am a ivan savelev, Who are you? ", is(result));
    }
}
