public class StringStack {
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE = 10;

    public StringStack() {
        this(DEFAULT_SIZE);
    }

    public StringStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size!");
        } else {
            elements = new String[size];
        }
    }

    public String pop() {
        if (count <= 0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty.");
        } else {
            return elements[--count];
        }
    }

    public String pop(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Must enter positive integer");
        } else {
            String result = "";
            for (int i = 0; i < n; i++) {
                result = pop();
            }
            return result;
        }
    }

    public void push(String item) {
        if (count >= elements.length) {
            throw new ArrayIndexOutOfBoundsException("Stack is full!");
        } else {
            elements[count++] = item;
        }
    }

    public int size() {
        return count;
    }

    public String toString() {
        if (size() == 0) {
            return "EMPTY";
        }

        String str = "";
        for (int i = 0; i < count - 1; i++) {
            str += elements[i] + ", ";
        }
        return str + elements[size() - 1];
    }

    public String peek() {
        return elements[count - 1];
    }

    public static void main(String[] args) {
        StringStack stack = new StringStack(20);
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        System.out.println(stack);
        System.out.println(stack.size());
        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();


        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(stack);
        System.out.println(stack.size());

        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        System.out.println(stack.pop(3));
    }

}
