package ExamPrep.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int ID;

    public Repository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Person person) {
        data.put(ID++, person);
    }

    public Person get(int i) {
        return this.data.get(i);
    }

    public boolean update(int i, Person person) {
        if (this.data.containsKey(i)) {
            this.data.put(i, person);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int i) {
        if (this.data.containsKey(i)) {
            this.data.remove(i);
            this.ID--;
            return true;
        } else {
            return false;
        }
    }

    public int getCount() {
        return this.data.size();
    }
}
