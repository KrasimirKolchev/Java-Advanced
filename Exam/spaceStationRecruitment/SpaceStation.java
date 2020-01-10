package Exam.spaceStationRecruitment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SpaceStation {
    private Map<String, Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.data = new LinkedHashMap<>(capacity);
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.data.size() < capacity) {
            this.data.put(astronaut.getName(), astronaut);
        }
    }

    public boolean remove(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }
        return false;
    }


    public Astronaut getAstronaut(String name) {
        return this.data.get(name);
    }

    public Astronaut getOldestAstronaut() {
        return this .data.values().stream().sorted((a1, a2) -> a2.getAge() - a1.getAge())
                .collect(Collectors.toList()).get(0);
    }
}
