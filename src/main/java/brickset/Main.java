package brickset;

/**
 * @author Nie Weilin
 * @version 1.2
 */
public class Main {
    public static void main(String[] args) {
        LegoSetRepository repository = new <LegoSet>LegoSetRepository();
        /*
         *Run the 5 methods
         */
        try {
            System.out.println(repository.printWithHighestNumber());
            System.out.println(repository.printWithFullInformation());
            System.out.println(repository.printWithPieces(92));
            System.out.println(repository.printWithNameStart("a"));
            System.out.println(repository.printWithAveragePieces());
        }
        catch (Exception e){
            System.out.println("Exception thrown  :" +e);
        }
    }
}
