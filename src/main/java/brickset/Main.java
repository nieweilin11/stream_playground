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
          System.out.println(repository.printWithPieces(12));
            System.out.println(repository.printWithAll());
            System.out.println(repository.printWithTotalPieces());
            System.out.println(repository.printWithNameStart("a"));
            System.out.println(repository.printWithNameIsOodAndEven());


    }
}
