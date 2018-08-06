package ioc.Demo_11;


import java.util.*;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */
public class People {

    private int id;
    private String name;
    private int age;

    Properties properties=new Properties();

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Map<String,String> works=new HashMap<>();

    public Map<String, String> getWorks() {
        return works;
    }

    public void setWorks(Map<String, String> works) {
        this.works = works;
    }

    private Set<String> loves=new HashSet<>();

    public Set<String> getLoves() {
        return loves;
    }

    public void setLoves(Set<String> loves) {
        this.loves = loves;
    }

    private List<String> hobbies=new ArrayList<>();

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", properties=" + properties +
                ", works=" + works +
                ", loves=" + loves +
                ", hobbies=" + hobbies +
                '}';
    }
}
