package ComparablevsComparator;

import java.util.ArrayList;
import java.util.Comparator;

// Demo for Comparator interface, which provides the customised sorting order.

class Movie1{

    String name;
    double rating;
    int year;

    Movie1(String name, double rating, int year){
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

class MyComparator implements Comparator<Movie1>{

    public int compare(Movie1 m1, Movie1 m2){
       return m1.year>m2.year?1:m1.year<m2.year?-1:0;
       //return Integer.compare(m1.year,m2.year);
    }
}

public class ComparatorDemo {

    public static void main(String[] args) {
        
        ArrayList<Movie1> movieList = new ArrayList<>();
        movieList.add(new Movie1("DDLJ",4.0,1994));
        movieList.add(new Movie1("Sholay",4.5, 1975));
        movieList.add(new Movie1("ABCD",3.5,2016));

        // max(), sort()

        // movieList.stream().max((m1,m2)-> m)

    //     // Before sorting.
    //     System.out.println("Before sorting");
    //     movieList.stream().forEach(m-> System.out.print(m.name + " "));

    //     // By Using lambda expressions.
    //     //Collections.sort(movieList, new MyComparator());
    //    // movieList.stream().forEach(m-> System.out.print(m.name + " "));

    // //   ; Comparator<Movie1> cmp = (m1,m2)->{
    // //         return m1.year-m2.year;
    // //    }
    //    System.out.println();
    //    System.out.println("After sorting");
    //    Collections.sort(movieList,(m1,m2)-> m1.year-m2.year);
    //    movieList.stream().forEach(m-> System.out.print(m.name + " "));


    }
    
}
