package brickset;

/**
 * @author Nie Weilin
 * @version 1.1.0
 */
public class Main {
    public static void main(String[] args) {
        LegoSetRepository repository = new <LegoSet>LegoSetRepository();
        /**
         *
         */
        System.out.println("Method_1");
        repository.printLegoSetWithHighestNumber();
        System.out.println("Method_2");
        repository.printLegoSetWithFullInformation();
        System.out.println("Method_3");
        repository.printLegoSetWith(12);
        System.out.println("Method_4");
        repository.printLegoSetNameStartWith("a");
        System.out.println("Method_5");
        System.out.println(repository.printLegoSetWithAveragePieces());

    }
}
