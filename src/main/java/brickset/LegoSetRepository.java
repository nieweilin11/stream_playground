package brickset;
import repository.Repository;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Nie Weilin
 * @version 1.3
 */

public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Method_1
     * This method return the highest number of Lego bricks
     * @return Lego Name with List<String>
     */
    public List<String> printWithHighestNumber(){
        System.out.println("Method_1");
           return getAll().stream().
               filter(s->s.getName()!=null&&s.getNumber()!=null).
                sorted(Comparator.comparing(LegoSet::getNumber)).
               limit(1).
               map(LegoSet::getName).
                collect(Collectors.toList());
    }
    /**
     * Method_2
     *This method return the Lego bricks which have every information is not null
     * @return Lego Name with List<String>
     */
    public List<String> printWithFullInformation(){
        System.out.println("Method_2");
         return getAll().stream().
                 filter(Objects::nonNull)
                 .map(LegoSet::getName).
                 collect(Collectors.toList());
    }
    /**
     * Method_3
     *This method is used to print the Lego bricks which has the same pieces as the input pieces
     * @param pieces is an int value
     * @return Lego object with List<LegoSet>
     * @throws IllegalArgumentException if input less than 0 or greater than 1000000
     */
    public List<LegoSet> printWithPieces(int pieces){
        System.out.println("Method_3");
        if(pieces<0||pieces>1000000){
            throw new IllegalArgumentException("Out of range");
        }
        return  getAll().stream().
                filter(s -> s.getPieces()==pieces&&s.getName()!=null).
                collect(Collectors.toList());

    }
    /**
     * Method_4
     * This method is used to print the Lego brick which name is start with the input Sting
     * @param pattern is a  String value
     * @return Lego Name with List<String>
     * @throws IllegalArgumentException if patter contain more one Letter
     */
    public List<String> printWithNameStart(String pattern){
        System.out.println("Method_4");
        if(pattern.length()>1){
            throw new IllegalArgumentException("More than one letter");
        }
         return getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                filter(s->s.startsWith(pattern)).
                 collect(Collectors.toList());
    }
    /**
     * Method_5
     *This method return an average pieces of Lego bricks
     * @return Average with double
     */
    public Double printWithAveragePieces(){
        System.out.println("Method_5");
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                filter(Objects::nonNull).
                average().
                getAsDouble();
    }
}

