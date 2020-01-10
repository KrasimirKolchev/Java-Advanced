package ExamPrep.CustomStack;

public class Main {
    public static void main(String[] args) {

        CustomStack customStack = new CustomStack();

        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        System.out.println(customStack.pop());
        System.out.println(customStack.peek());
        System.out.println(customStack.getSize());
        customStack.forEach(System.out::println);

        System.out.println();
    }
}
