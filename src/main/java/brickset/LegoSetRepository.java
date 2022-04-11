package brickset;
import repository.Repository;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Nie Weilin
 * @version 1.4
 */

public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }
    /**
     * Method_1
     *This method is used to print the Lego bricks which has the same pieces as the input pieces
     * @param pieces is an int value
     * @return boolean value
     *
     */
    public boolean printWithPieces(int pieces){
        System.out.println("Method_1");
        return  getAll().stream().
                anyMatch(s -> s.getPieces()==pieces&&s.getName()!=null);
    }

    /**
     * Method_2
     * This method return all of Lego bricks
     * @return Lego Name with List<String>
     */
    public List<String> printWithAll(){
        System.out.println("Method_2");
           return getAll().stream().
               filter(s->s.getName()!=null&&s.getNumber()!=null).
                sorted(Comparator.comparing(LegoSet::getNumber)).
                   map(LegoSet::getName).
               flatMap(x-> Arrays.stream(x.split(" "))).
                collect(Collectors.toList());
    }
    /**
     * Method_3
     *This method return the total Lego bricks pieces which have every information is not null
     * @return int value
     */
    public int printWithTotalPieces(){
        System.out.println("Method_3");
         return getAll().stream().
                 filter(Objects::nonNull).
                 map(LegoSet::getPieces).
                 reduce(1, Integer::sum);
    }

    /**
     * Method_4
     * This method is used to print the Lego brick which name is start with the input Sting and return as a map that
     * key is the name of brick and value is the length of the name
     * @param pattern is a  String value
     * @return Map<String, Integer>
     *
     */
    public Map<String, Integer> printWithNameStart(String pattern){
        System.out.println("Method_4");
         return getAll().stream().
                map(LegoSet::getName).
                 filter(Objects::nonNull).
                map(String::toLowerCase).
                filter(s->s.startsWith(pattern)).
                 collect(Collectors.toMap(v->v, String::length));
    }
    /**
     * Method_5
     *This method return two lists ,contain even length of name  and odd length of name
     * @return Map<Boolean,List<String>>
     */
    public Map<Boolean,List<String>> printWithNameIsOodAndEven(){
        System.out.println("Method_5");
        return getAll().stream().
                map(LegoSet::getName).
                filter(Objects::nonNull).
         collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));
    }
}

