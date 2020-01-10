package ExamPrep.heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public List<Hero> getData() {
        return data;
    }

    public void add(Hero hero) {
        this.data.add(hero);
    }

    public void remove(String hero_name) {
        int index = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(hero_name)) {
                this.data.remove(i);
            }
        }
    }

    public Hero getHeroWithHighestStrength() {
        int index = 0;
        int higher = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getItem().getStrength() > higher) {
                index = i;
                higher = this.data.get(i).getItem().getStrength();
            }
        }
        return this.data.get(index);
    }

    public Hero getHeroWithHighestAgility() {
        int index = 0;
        int higher = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getItem().getAgility() > higher) {
                index = i;
                higher = this.data.get(i).getItem().getAgility();
            }
        }
        return this.data.get(index);
    }

    public Hero getHeroWithHighestIntelligence() {
        int index = 0;
        int higher = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getItem().getIntelligence() > higher) {
                index = i;
                higher = this.data.get(i).getItem().getIntelligence();
            }
        }
        return this.data.get(index);
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : this.data) {
            sb.append(hero.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
