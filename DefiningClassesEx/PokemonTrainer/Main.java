package DefiningClassesEx.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command;

        while (!"Tournament".equals(command = reader.readLine())) {
            String[] lineInfo = command.split("\\s+");

            String player = lineInfo[0];
            String pokemon = lineInfo[1];
            String element = lineInfo[2];
            int health = Integer.parseInt(lineInfo[3]);

            Trainer.trainerMap.putIfAbsent(player, new Trainer(player));
            Trainer trainer = Trainer.trainerMap.get(player);
            trainer.addPokemon(pokemon, element, health);
        }

        while (!"End".equals(command = reader.readLine())) {

            String element = command;
            Trainer.trainerMap.values().forEach(t -> {
                if (!t.containPokemon(element)) {
                    t.loseHealth();
                }
            });

        }

        Trainer.trainerMap.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(t -> System.out.println(String.format("%s %d %d",
                        t.getTrainerName(), t.getBadges(), t.getPokemonMap().size())));
    }
}
