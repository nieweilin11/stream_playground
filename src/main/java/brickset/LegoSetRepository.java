package brickset;
import repository.Repository;
import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    public Stream<LegoSet> printLegoSetWithHighestNumber(){//Method_1
       return getAll().stream().
                sorted(Comparator.comparing(LegoSet::getNumber)).
                filter(LegoSet->LegoSet.getName()!=null).
                limit(1)
               ;
    }
    public Stream<LegoSet> printLegoSetWithFullInformation(){//Method_2
         return getAll().stream().
                 filter(Objects::nonNull);
    }
    public Stream<LegoSet> printLegoSetWith(int pieces){
        return getAll().stream().
                filter(legoSet -> legoSet.getPieces()==pieces&&legoSet.getName()!=null);
    }
    public Stream<Boolean> printLegoSetNameStartWith(String pattern){
        return getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                map(s->s.startsWith(pattern))
                ;
    }
    public Double printLegoSetWithAveragePieces(){
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                filter(Objects::nonNull).
                average().
                getAsDouble()
                ;

    }

}

