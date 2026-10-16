public class Main {

    public static void main(String[] args) {
        System.out.println("max(3, 9) = " + max(3, 9));             // 9
        System.out.println("max(3, 9, 5) = " + max(3, 9, 5));       // 9
        int[] numbers = {4, 17, 8, 12};
        System.out.println("max(array) = " + max(numbers));         // 17

        printLine();             // 20 dashes
        printLine(10);           // 10 dashes
        printLine(10, '=');      // ==========

        int[] ages = {18, 21, 20};
        double[] grades = {12.5, 15.0, 9.5};
        System.out.println("average(int[]) = " + average(ages));      // 19.666...
        System.out.println("average(double[]) = " + average(grades)); // 12.333...

        System.out.println("count = " + count("banana", 'a'));      // 3

        System.out.println(repeatText("Java ", 3));                 // Java Java Java
    }

    // Bigger of two numbers
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    // Bigger of three numbers - reuses max(a, b)
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Bigger value in an array
    public static int max(int[] values) {
        int biggest = values[0];
        for (int v : values) {
            biggest = max(biggest, v);   // reuses max(a, b)
        }
        return biggest;
    }

    // ---------- printLine ----------

    // Complete version: n times the character c
    public static void printLine(int n, char c) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    // n dashes - calls the complete version
    public static void printLine(int n) {
        printLine(n, '-');
    }

    // 20 dashes - calls the complete version
    public static void printLine() {
        printLine(20, '-');
    }

    // ---------- average ----------

    public static double average(int[] values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;   // cast: avoid integer division
    }

    public static double average(double[] values) {
        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.length;
    }

    // ---------- count ----------

    // How many times c appears in the text
    public static int count(String text, char c) {
        int total = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                total++;
            }
        }
        return total;
    }

    // ---------- repeatText ----------

    // Returns the text repeated n times (with StringBuilder, without repeat)
    public static String repeatText(String text, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
