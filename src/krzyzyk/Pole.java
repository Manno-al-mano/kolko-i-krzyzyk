package krzyzyk;
import java.util.Scanner;
public class Pole {
    String pole;
    char[] wyniki={'1','2','3','4','5','6','7','8','9'};
    boolean isX=true;
    boolean isBot=false;
    int round=0;
    static int pktO=0;
    static int pktX=0;
    Pole(){
        rysuj_pole();
    }
    void rysuj_pole(){
        pole = wyniki[0]+"|"+wyniki[1]+"|"+wyniki[2]+"\n"+
                wyniki[3]+"|"+wyniki[4]+"|"+wyniki[5]+"\n"+
                wyniki[6]+"|"+wyniki[7]+"|"+wyniki[8];
    }
    void printPole(){
        rysuj_pole();
        System.out.println(pole);
    }

    static void start(){
        Pole gra= new Pole();
        System.out.println("Witam w grze w Kółko i Krzyżyk!\nBy wybrać 1 gracza, napisz 1\nBy wybrać 2 graczy napisz 2");
        gra.mainMenu();


    }

    void mainMenu(){
        Scanner scan = new Scanner(System.in);
        String nextln = scan.nextLine();
        if(nextln.equals("1")){
            isBot=true;
            menu();
        }
        else if(nextln.equals("2")){
            System.out.println("Zaczyna X czy O");
            multiplayer();
        }
        else{
            System.out.println("Wybierz 1 lub 2");
            mainMenu();
        }
    }

    void  multiplayer(){
        Scanner scan = new Scanner(System.in);
        String nextln = scan.nextLine();
        if(nextln.equals("X")){
            menu();
        }
        else if(nextln.equals("O")){
            isX=false;
            menu();
        }
        else {
            System.out.println("Wybierz X lub O");
            multiplayer();
        }

    }
    void botFill(){
        int wylosowanepole=(int)(Math.random()*9);
        if (wyniki[wylosowanepole]!='X'&&wyniki[wylosowanepole]!='O') {
            wyniki[wylosowanepole] = 'O';
            isX = true;
            round++;
            System.out.println("-----");

        }
        else{botFill();}
    }


    void menu(){
        printPole();
        if (round<9){
        Scanner scan = new Scanner(System.in);
        if(isX||!isBot){
        System.out.println("Podaj numer pola");
        String nextln = scan.nextLine();
        if (nextln.length() == 1 && (
                        nextln.equals("1" ) ||
                        nextln.equals("2") ||
                        nextln.equals("3") ||
                        nextln.equals("4" )||
                        nextln.equals("5" )||
                        nextln.equals("6" )||
                        nextln.equals("7" )||
                        nextln.equals("8" )||
                        nextln.equals("9")
        )
        ){
            fill_pole(nextln);
        }
        else{
            System.out.println("Podano niewłaściwy numer pola");
        }}
        else {
            botFill();
        }
        if(checkVictory()){
            if(isX){
                printPole();
                pktO++;
                System.out.println("Gratulacje, wygrało kółko, krzyżyk - "+pktX+", kółko - "+pktO+
                        ", wybierz x żeby kontynuować lub dowolny inny przycisk żeby wyjść");
                Scanner scan1 = new Scanner(System.in);
                String nextln1 = scan1.nextLine();
                if(nextln1.equals("x"))
                    start();

            }
            else {
                printPole();
                pktX++;
                System.out.println("Gratulacje, wygrał krzyżyk, krzyżyk - "+pktX+", kółko - "+pktO+
                        ", wybierz x żeby kontynuować lub dowolny inny przycisk żeby wyjść");
                Scanner scan2 = new Scanner(System.in);
                String nextln2 = scan2.nextLine();
                if(nextln2.equals("x"))
                   start();

            }
        }
        else{menu();}
    }
        else {
            pktO++; pktX++;
            System.out.println("Remis, krzyżyk - "+pktX+", kółko - "+pktO+
                    ", wybierz x żeby kontynuować lub dowolny inny przycisk żeby wyjść");
            Scanner scan3 = new Scanner(System.in);
            String nextln3 = scan3.nextLine();
            if(nextln3.equals("x"))
                start();
        }
    }

    boolean checkVictory(){
        if (wyniki[0]==wyniki[1]&&wyniki[1]==wyniki[2]){
            return true;}
        else  if (wyniki[3]==wyniki[4]&&wyniki[4]==wyniki[5]){
            return true;}
        else  if (wyniki[6]==wyniki[7]&&wyniki[7]==wyniki[8]){
            return true;}
        else  if (wyniki[0]==wyniki[3]&&wyniki[3]==wyniki[6]){
            return true;}
        else  if (wyniki[1]==wyniki[4]&&wyniki[4]==wyniki[7]){
            return true;}
        else  if (wyniki[2]==wyniki[5]&&wyniki[5]==wyniki[8]){
            return true;}
        else  if (wyniki[0]==wyniki[4]&&wyniki[4]==wyniki[8]){
            return true;}
        else  if (wyniki[2]==wyniki[4]&&wyniki[4]==wyniki[6]){
            return true;}
        else{
            return false;
        }
    }
    void fill_pole(String nextln) {

            int odp = Integer.parseInt(nextln)-1;
            if(wyniki[odp]!='X'&&wyniki[odp]!='O') {
                if (isX) {
                    wyniki[odp] = 'X';
                    isX = false;
                    round++;
                } else {

                    wyniki[odp] = 'O';
                    isX = true;
                    round++;
                }
            }

            else{
                System.out.println("pole zostało już wybrane");
                menu();
            }

    }

}