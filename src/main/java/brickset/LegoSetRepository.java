package brickset;
import repository.Repository;
import java.util.Comparator;
import java.util.Objects;


/**
 * @author Nie Weilin
 * @version 1.2
 */

public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Method_1
     * This method return the highest number of Lego bricks
     * @return Nothing
     */
    public void printWithHighestNumber(){
        getAll().stream().
               filter(s->s.getName()!=null&&s.getNumber()!=null).
                sorted(Comparator.comparing(LegoSet::getNumber)).
               limit(1).
               map(LegoSet::getName).
                forEach(System.out::println);
    }
    /**
     * Method_2
     *This method return the Lego bricks which have every information is not null
     * @return Nothing
     */
    public void printWithFullInformation(){
         getAll().stream().
                 filter(Objects::nonNull)
                 .map(LegoSet::getName).
                 forEach(System.out::println);
    }
    /**
     * Method_3
     *This method is used to print the Lego bricks which has the same pieces as the input pieces
     * @param pieces is an int value
     * @return Nothing
     */
    public void printWithPieces(int pieces){
         getAll().stream().
                filter(legoSet -> legoSet.getPieces()==pieces&&legoSet.getName()!=null).
                 forEach(System.out::println);
    }

    /**
     * Method_4
     * This method is used to print the Lego brick which name is start with the input Sting
     * @param pattern is a  String value
     * @throws IllegalArgumentException if patter contain more one Letter
     */
    public void printWithNameStart(String pattern){
        if(pattern.length()>1){
            throw new IllegalArgumentException("Enter at last 1 letter");
        }
         getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                filter(s->s.startsWith(pattern)).
                 forEach(System.out::println);

    }

    /**
     * Method_5
     *This method return an average pieces of Lego bricks
     * @return Double value
     */
    public Double printWithAveragePieces(){
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                filter(Objects::nonNull).
                average().
                getAsDouble();
    }

}

