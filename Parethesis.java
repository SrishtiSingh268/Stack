package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Parethesis {
	public static void main(String[] srgs) {
		System.out.println("Enter string of parenthesis: ");
		Scanner scan = new Scanner(System.in);
		int count = 0;
		Stack<String> stack = new Stack<>();
		String str = new String();
		str = scan.nextLine().trim();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{') {
				stack.push("" + str.charAt(i));
			} else if (str.charAt(i) == '}') {
				if (!stack.isEmpty()) {
					String s = stack.peek();
					if (s.equals("{")) {
						stack.pop();
						count++;
					} else
						stack.push("" + str.charAt(i));
				}
			}

		}
		System.out.println(count);

	}
}
