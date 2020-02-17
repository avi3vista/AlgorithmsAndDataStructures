import java.util.Stack;

public class experiment {


    public static void main(String[] args) {
        String s = "30[ab4[c]]";
        System.out.println("String s = " + s + "  Decodeded = " + decodeString(s));
        s = "3[a]2[bc]";
        System.out.println("String s = " + s + "  Decodeded = " + decodeString(s));
        s = "3[a2[c]]";
        System.out.println("String s = " + s + "  Decodeded = " + decodeString(s));
        s = "2[abc]3[cd]ef";
        System.out.println("String s = " + s + "  Decodeded = " + decodeString(s));

    }


    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> result = new Stack();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;

            } else {
                res += s.charAt(index);
                index++;
            }
        }
        return res;

    }
}
