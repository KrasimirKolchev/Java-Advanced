package DefiningClassesEx.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Trainer {

    private static final int DEFAULT_VALUE = 0;
    static Map<String, Trainer> trainerMap = new LinkedHashMap<>();

    private String trainerName;
    private int badges;
    private HashMap<String, Pokemon> pokemonMap;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.badges = DEFAULT_VALUE;
        this.pokemonMap = new HashMap<>();
    }

    public HashMap<String, Pokemon> getPokemonMap() {
        return pokemonMap;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getBadges() {
        return badges;
    }

    public void addPokemon(String name, String element, int health) {
        this.pokemonMap.put(name, new Pokemon(name, element, health));
    }

    public boolean containPokemon(String element) {
        if (this.pokemonMap.values().stream().anyMatch(e -> e.getElement().equals(element))) {
            this.badges++;
            return true;
        }
        return false;
    }

    public void loseHealth() {
        this.pokemonMap = pokemonMap.entrySet().stream().filter(e -> e.getValue().reduceHealth())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
    }

    class Pokemon {
        private String name;
        private String element;
        private int health;

        public Pokemon(String name, String element, int health) {
            this.name = name;
            this.element = element;
            this.health = health;
        }

        public boolean reduceHealth() {
            this.health = this.health - 10;
            return this.health > 0;
        }

        public String getElement() {
            return element;
        }
    }
}
