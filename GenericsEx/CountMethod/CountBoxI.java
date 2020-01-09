package GenericsEx.CountMethod;


public class CountBoxI<T extends Comparable<T>> {
    private T data;

    public CountBoxI(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
