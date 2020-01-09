package DefiningClassesEx.Google;

import java.util.LinkedHashMap;
import java.util.Map;

public class GPerson {

    static Map<String, GPerson> persons = new LinkedHashMap<>();

    private String name;
    private Company company;
    private GCar gCar;
    private Map<String, GPokemon> gPokemons = new LinkedHashMap<>();
    private Map<String, Parent> parents = new LinkedHashMap<>();
    private Map<String, Child> childrens = new LinkedHashMap<>();

    public GPerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setgCar(GCar gCar) {
        this.gCar = gCar;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public GCar getgCar() {
        return gCar;
    }

    public Map<String, GPokemon> getgPokemons() {
        return gPokemons;
    }

    public Map<String, Parent> getParents() {
        return parents;
    }

    public Map<String, Child> getChildrens() {
        return childrens;
    }

    public void addChild(String name, String birth) {
        this.childrens.put(name, new Child(name, birth));
    }

    public void addGPokemons(String name, String element) {
        this.gPokemons.put(name, new GPokemon(name, element));
    }

    public void addParents(String name, String birth) {
        this.parents.put(name, new Parent(name, birth));
    }

    static class Company {
        private String comName;
        private String department;
        private String salary;

        public Company(String comName, String department, String salary) {
            this.comName = comName;
            this.department = department;
            this.salary = salary;
        }

        public String getComName() {
            return comName;
        }

        public String getDepartment() {
            return department;
        }

        public String getSalary() {
            return salary;
        }
    }

    static class GCar {
        private String model;
        private String speed;

        public GCar(String model, String speed) {
            this.model = model;
            this.speed = speed;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }
    }

    static class GPokemon {
        private String name;
        private String element;

        public GPokemon(String name, String element) {
            this.name = name;
            this.element = element;
        }

        public String getName() {
            return name;
        }

        public String getElement() {
            return element;
        }
    }

    static class Parent {
        private String name;
        private String Birht;

        public Parent(String name, String birht) {
            this.name = name;
            Birht = birht;
        }

        public String getName() {
            return name;
        }

        public String getBirht() {
            return Birht;
        }
    }

    static class Child {
        private String name;
        private String birth;

        public Child(String name, String birth) {
            this.name = name;
            this.birth = birth;
        }

        public String getName() {
            return name;
        }

        public String getBirth() {
            return birth;
        }
    }
}
