package brickset;
import repository.Repository;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Nie Weilin
 * @version 1.1.0
 */

public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }
    /**
     * This method return the highest number of Lego object
     * @return  Lego object
     *
     */
    public void printLegoSetWithHighestNumber(){
        getAll().stream().
               filter(s->s.getName()!=null&&s.getNumber()!=null).
                sorted(Comparator.comparing(s->s.getNumber())).
               limit(1).
               map(s->s.getName().toString()).
                forEach(System.out::println);

    }
    /**
     *This method return the lego objects which have every information is not null
     * @return Lego object
     *
     */
    public void printLegoSetWithFullInformation(){
         getAll().stream().
                 filter(Objects::nonNull)
                 .map(s->s.getName().toString()).
                 forEach(System.out::println);
    }
    /**
     *This method
     * @param pieces is int
     * @return Lego object
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

