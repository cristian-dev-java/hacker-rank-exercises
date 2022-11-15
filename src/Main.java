import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hacker Rank");
    }

    /**
     * Método que permite hayar el max entre 3 números
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static int maxBetween(int x, int y, int z){
        var firtsMax = x > y ? x : y;
        return firtsMax > z ? firtsMax : z;
    }

    /**
     * Método que permite equilbrar la altura max de cada stack de cilindros
     * y retorna dicha altura max
     * @param h1
     * @param h2
     * @param h3
     * @return
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        var stacksSumH1 = h1.stream().mapToInt(i->i).sum();
        var stacksSumH2 = h2.stream().mapToInt(i->i).sum();
        var stacksSumH3 = h3.stream().mapToInt(i->i).sum();
        while(!(stacksSumH1==stacksSumH2 && stacksSumH1==stacksSumH3)){
            var maxBet = maxBetween(stacksSumH1, stacksSumH2,stacksSumH3);
            if(stacksSumH1==maxBet){
                stacksSumH1 = stacksSumH1 - h1.remove(0);
            }else if(stacksSumH2==maxBet){
                stacksSumH2 = stacksSumH2 - h2.remove(0);
            }else if(stacksSumH3==maxBet){
                stacksSumH3 = stacksSumH3 - h3.remove(0);
            }
        }
        return stacksSumH1;
    }
}