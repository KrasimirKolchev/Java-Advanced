package GenericsEx.SwapMethod;

public class BoxI<T> {
    private T data;

    public BoxI(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }


}

