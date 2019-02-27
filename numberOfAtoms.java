package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class numberOfAtoms {
    static public String countOfAtoms(String formula) {
        HashMap<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        String word = "";
        for(int i=0; i< formula.length(); ){
            if(formula.charAt(i) != '(' && formula.charAt(i) != ')'){
                word = "" +formula.charAt(i);
                //determine element
                while(++i < formula.length() && formula.charAt(i) > 96 && formula.charAt(i) < 123)
                    word = word + formula.charAt(i);
                
                //determine degree of element
                int num = 1;
                if(i < formula.length() && formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                    num = formula.charAt(i++) - 48;
                    while(i < formula.length() && formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                        num = num*10 + formula.charAt(i) - 48;
                        i++;
                    }
                }
                if(i < formula.length() && map.containsKey(formula.charAt(i)))
                    map.put(word, map.get(formula.charAt(i)) + num); 
                else 
                    map.put(word, num); 
                
            } else {
                stack.push("("); i++;
                int x = 1; //number of opening bracket
                while(x >= 1 && i < formula.length()) {
                    word = ""+ formula.charAt(i);
                    
                    if(word.equals("(")) {
                        stack.push(word);
                        x++;
                        i++;
                    } else if (!word.equals(")")){
                      //determine element
                        while(++i < formula.length() && formula.charAt(i) > 96 && formula.charAt(i) < 123)
                            word = word + formula.charAt(i);
                      //determine degree of element
                        int num = 1;
                        if(i < formula.length() && formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                            num = formula.charAt(i) - 48;
                            while(i < formula.length() && formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                                num = num*10 + formula.charAt(i) - 48;
                                i++;
                            }
                        }
                        for(int y = 0; y <num; y++)
                            stack.push(word);
                    }
                    if(word.equals(")")) {
                        int num = 1;
                        if(++i < formula.length() && formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                            num = formula.charAt(i) - 48;
                            while(++i < formula.length()&& formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                                num = num*10 + formula.charAt(i) - 48;
                                i++;
                            }
                        }
                       x--;
                       
                       String c = stack.pop();
                       ArrayList<String> temp = new ArrayList<>();
                       while(!c.equals("(")){
                           for(int y = 0; y<num; y++){
                               //stack.add(c);
                               temp.add(c);
                           }
                           c = stack.pop();
                       }
                       for(int y = 0; y < temp.size(); y++)
                           stack.push(temp.get(y));
                    }
                }
                while(!stack.isEmpty()){
                    word = stack.pop();
                    if(map.containsKey(word))
                        map.put(word, map.get(word) + 1); 
                    else 
                        map.put(word, 1); 
                }
            }
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        String val = "K4(ON(SO3)2)2";
        countOfAtoms(val);
    }

}
