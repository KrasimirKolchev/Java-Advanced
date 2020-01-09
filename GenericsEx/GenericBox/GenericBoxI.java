package GenericsEx.GenericBox;


public class GenericBoxI<T> {
    private T data;

    public GenericBoxI(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }
}
