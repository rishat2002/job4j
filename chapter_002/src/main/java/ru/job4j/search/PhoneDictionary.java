package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var list:persons) {
            if(list.getAddress().contains(key) || list.getName().contains(key) || list.getPhone().contains(key) || list.getSurname().contains(key) ) {
                result.add(list);
            }
        }
        return result;
    }
}
