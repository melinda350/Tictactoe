import java.util.*;

public class Main{
    static ArrayList<Character>playerPosition = new ArrayList<Character>();
    static ArrayList<Character>cpuPosition= new ArrayList<Character>();

    public static void main(String[] args){



        char[][] gameBoard= {{' ','!',' ','!',' '},
                {'-','+','-','+','-'},
                {' ','!',' ','!',' '},
                {'-','+','-','+','-'},
                {' ','!',' ','!',' '}};
         //would have jumped a line but my keyboard is not working and i cant find the slash
        while(true){
        Scanner scanner= new Scanner(System.in);
        System.out.print("input a value from a - i : ");
        //int pos= scanner.nextInt();
        char pos= scanner.next().charAt(0);
        //System.out.print("this is what you printed out " + pos + " ");
        while(playerPosition.contains(pos) || cpuPosition.contains(playerPosition)){
        System.out.print("position taken");
        pos=scanner.next().charAt(0);

        }
        placement(gameBoard, pos, "player");

        Random rand= new Random();
        char cpuPos= (char)(rand.nextInt(9) + 'a');
            while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPosition)){
                System.out.print("position taken");
                cpuPos= (char)(rand.nextInt(9) + 'a');

            }
        placement(gameBoard, cpuPos, "cpu");
        printGameBoard(gameBoard);
        String result=checkWinner();
        System.out.println(result);
}




    }
    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
            // System.out.println(gameBoard);




        }


    }
    public static void placement(char[][] gameBoard, char pos, String user){
        char symbol=' ';

        if(user.equals("player")){
            symbol='X';
            playerPosition.add(pos);

        } else if (user.equals("cpu")) {
            symbol='o';
            cpuPosition.add(pos);

        }

        if( pos== 'a'){
            gameBoard[0][0]=symbol;

        } else if (pos == 'b') {
            gameBoard[0][2]=symbol;

        } else if (pos == 'c') {
            gameBoard[0][4]=symbol;

        }else if (pos == 'd') {
            gameBoard[2][0] = symbol;
        }
        else if (pos == 'e') {
            gameBoard[2][2] = symbol;
        }
        else if (pos == 'f') {
            gameBoard[2][4] = symbol;
        }
        else if (pos == 'g') {
            gameBoard[4][0] = symbol;
        }
        else if (pos == 'h') {
            gameBoard[4][2] = symbol;
        }
        else if (pos == 'i') {
            gameBoard[4][4] = symbol;
        }
        else {
            System.out.println("invalid input ");
        }
        //System.out.println(gameBoard);


    }

    public static String checkWinner(){
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        List leftcol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol=Arrays.asList(3,6,9);
        List firstDig=Arrays.asList(1,5,9);
        List secDig= Arrays.asList(7,5,3);

        List<List> winning= new ArrayList<>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftcol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(firstDig);
        winning.add(secDig);

        for(List l:winning){
            if(playerPosition.containsAll(l)){
                //System.out.println("congratulations ");
                return "congratulations";

            }else if(cpuPosition.containsAll(l)){
                //System.out.println("cpu wins ");
                return "cpu wins";
            }
            else if (playerPosition.size()+ cpuPosition.size()==9) {
                return " ";

            }


        }

        return "";
    }


}