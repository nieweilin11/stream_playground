package brickset;

/**
 * @author Nie Weilin
 * @version 1.1.0
 */
public class Main {
    public static void main(String[] args) {
        LegoSetRepository repository = new <LegoSet>LegoSetRepository();
        /*
         *Run the 5 methods
         */
        try {
            System.out.println("Method_1");
            repository.printWithHighestNumber();
            System.out.println("Method_2");
            repository.printWithFullInformation();
            System.out.println("Method_3");
            repository.printWithPieces(12);
            System.out.println("Method_4");
            repository.printWithNameStart("a");
            System.out.println("Method_5");
            System.out.println(repository.printWithAveragePieces());
        }
        catch (Exception e){
            System.out.println("Exception thrown  :" +e);
        }
    }
}
