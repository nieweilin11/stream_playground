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
     * This method return the highest number of Lego
     * @return Nothing
     *
     */
    public void printLegoSetWithHighestNumber(){
        getAll().stream().
               filter(s->s.getName()!=null&&s.getNumber()!=null).
                sorted(Comparator.comparing(LegoSet::getNumber)).
               limit(1).
               map(LegoSet::getName).
                forEach(System.out::println);

    }
    /**
     *This method return the lego  which have every information is not null
     * @return Nothing
     *
     */
    public void printLegoSetWithFullInformation(){
         getAll().stream().
                 filter(Objects::nonNull)
                 .map(LegoSet::getName).
                 forEach(System.out::println);
    }
    /**
     *This method is to find the  Lego which has the same pieces as the input pieces
     * @param pieces is int
     * @return Nothing
     */
    public void printLegoSetWith(int pieces){
         getAll().stream().
                filter(legoSet -> legoSet.getPieces()==pieces&&legoSet.getName()!=null).
                 forEach(System.out::println);
    }
    public void printLegoSetNameStartWith(String pattern){
         getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                filter(s->s.startsWith(pattern)).
                 forEach(System.out::println);

    }

    /**
     *This method return an average pieces of Lego
     * @return Double value
     */
    public Double printLegoSetWithAveragePieces(){
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                filter(Objects::nonNull).
                average().
                getAsDouble();
    }

}

