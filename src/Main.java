import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hacker Rank");
        var stringToBalance ="{{[[(())]]}}";
        System.out.println(isBalanced(stringToBalance));
    }

    /**
     * Método que permite balancear los brackets
     * @param s
     * @return
     */
    public static String isBalanced(String s) {
        var cadenaBuilder = new StringBuilder(s);
        var response = "YES";
        var mapBrackets = new HashMap<Character, Character>();
        mapBrackets.put('(', ')');
        mapBrackets.put('[', ']');
        mapBrackets.put('{', '}');

        if(s.length()%2!=0){
            return "NO";
        }
        for(int i=0;i<cadenaBuilder.length()-1;i++) {
            char char1 = cadenaBuilder.charAt(i);
            char char2 = cadenaBuilder.charAt(i+1);
            if (mapBrackets.get(char1)!= null && mapBrackets.get(char1) == char2) {
                cadenaBuilder.deleteCharAt(i);
                cadenaBuilder.deleteCharAt(i);
                i=-1;
            }
        }

        for(int i=0;i<cadenaBuilder.length()/2;i++) {
            char char1 = cadenaBuilder.charAt(i);
            char char2 = cadenaBuilder.charAt(cadenaBuilder.length() - 1 - i);
            if (mapBrackets.get(char1) == null || char2 != mapBrackets.get(char1)) {
                return "NO";
            }
        }
        return response;
    }
}