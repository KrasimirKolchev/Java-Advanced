package Generics.Jar;

public class JarOfPickles extends Jar<Pickle> {

    String getName(Pickle pickle) {
        return pickle.getName();
    }
}
