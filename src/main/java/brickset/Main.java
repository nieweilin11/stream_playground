package brickset;

/**
 * @author Nie Weilin
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        /**
         *
         */
        System.out.println(repository.printLegoSetWithHighestNumber());
        System.out.println(repository.printLegoSetWithFullInformation());
        System.out.println(repository.printLegoSetWith(12));
        System.out.println(repository.printLegoSetNameStartWith("a"));
        System.out.println(repository.printLegoSetWithAveragePieces());

    }
}
