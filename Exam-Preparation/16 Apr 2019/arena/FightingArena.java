package ExamPrep.arena;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FightingArena {
    private Map<String, Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.gladiators = new LinkedHashMap<>();
        this.name = name;
    }

    public void add(Gladiator g) {
        this.gladiators.put(g.getName(), g);
    }

    public void remove(String name) {
        this.gladiators.remove(name);
    }

    public int getCount() {
        return this.gladiators.size();
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return this.gladiators.values().stream().sorted((g1, g2) -> g2.getStatPower() - g1.getStatPower())
                .collect(Collectors.toList()).get(0);
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return this.gladiators.values().stream().sorted((g1, g2) -> g2.getWeaponPower() - g1.getWeaponPower())
                .collect(Collectors.toList()).get(0);
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return this.gladiators.values().stream().sorted((g1, g2) -> g2.getTotalPower() - g1.getTotalPower())
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating.", this.name, this.getCount());
    }
}
