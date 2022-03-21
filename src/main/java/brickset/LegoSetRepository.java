package brickset;
import repository.Repository;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Nie Weilin
 * @version 1.0.0
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
    public Stream<LegoSet> printLegoSetWithHighestNumber(){
       return getAll().stream().
                sorted(Comparator.comparing(LegoSet::getNumber)).
                filter(LegoSet->LegoSet.getName()!=null).
                limit(1);
    }
    /**
     *This method return the lego objects which have every information is not null
     * @return Lego object
     *
     */
    public Stream<LegoSet> printLegoSetWithFullInformation(){
         return getAll().stream().
                 filter(Objects::nonNull);
    }

    /**
     *This method
     * @param pieces is int
     * @return Lego object
     */
    public Stream<LegoSet> printLegoSetWith(int pieces){
        return getAll().stream().
                filter(legoSet -> legoSet.getPieces()==pieces&&legoSet.getName()!=null);
    }
    public Stream<Boolean> printLegoSetNameStartWith(String pattern){
        return getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                map(s->s.startsWith(pattern));
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

