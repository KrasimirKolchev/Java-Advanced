package DefiningClassesEx.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command;

        while (!"End".equals(command = reader.readLine())) {
            String[] info = command.split("\\s+");

            String name = info[0];
            GPerson.persons.putIfAbsent(name, new GPerson(name));
            GPerson gPerson = GPerson.persons.get(name);

            if (info.length == 5) {
                GPerson.Company company = new GPerson.Company(info[2], info[3], info[4]);
                gPerson.setCompany(company);
            } else if (info.length == 4) {
                switch (info[1]) {
                    case "car" :
                        GPerson.GCar car = new GPerson.GCar(info[2], info[3]);
                        gPerson.setgCar(car);
                        break;
                    case "pokemon" :
                        gPerson.addGPokemons(info[2], info[3]);
                        break;
                    case "parents" :
                        gPerson.addParents(info[2], info[3]);
                        break;
                    case "children" :
                        gPerson.addChild(info[2], info[3]);
                        break;
                }
            }
        }

        command = reader.readLine();
        String name = command;

        GPerson.persons.entrySet().stream().filter(e -> e.getKey().equals(name))
                .forEach(n -> {
                    System.out.println(n.getKey());
                    System.out.println("Company:");
                    if (n.getValue().getCompany() != null) {
                        System.out.println(String.format("%s %s %.2f", n.getValue().getCompany().getComName(),
                                n.getValue().getCompany().getDepartment(), Double.parseDouble(n.getValue().getCompany().getSalary())));
                    }

                    System.out.println("Car:");
                    if (n.getValue().getgCar() != null) {
                        System.out.println(String.format("%s %s", n.getValue().getgCar().getModel(),
                                n.getValue().getgCar().getSpeed()));
                    }

                    System.out.println("Pokemon:");
                    if (n.getValue().getgPokemons() != null) {
                        n.getValue().getgPokemons().entrySet().stream()
                                .forEach(p -> System.out.println(String.format("%s %s",
                                        p.getValue().getName(), p.getValue().getElement())));
                    }
                    System.out.println("Parents:");
                    if (n.getValue().getParents() != null) {
                        n.getValue().getParents().entrySet().stream()
                                .forEach(pa -> System.out.println(String.format("%s %s",
                                        pa.getValue().getName(), pa.getValue().getBirht())));
                    }

                    System.out.println("Children:");
                    if (n.getValue().getChildrens() != null) {
                        n.getValue().getChildrens().entrySet().stream()
                                .forEach(c -> System.out.println(String.format("%s %s",
                                        c.getValue().getName(), c.getValue().getBirth())));
                            }
                });
    }
}
