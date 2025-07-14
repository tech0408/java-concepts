package ComparablevsComparator;

import java.util.ArrayList;
import java.util.Collections;

// Demo of Comparable interface where we want to define the default
// sorting order for the movies which is sort based on the date.

class Movie implements Comparable<Movie>{

    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year){
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public int compareTo(Movie m){
        return this.year-m.year;
    }

}

public class ComparableDemo {

    public static void main(String[] args) {

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("DDLJ",4.0,1994));
        movieList.add(new Movie("Sholay",4.5, 1975));
        
        movieList.add(new Movie("ABCD",3.5,2016));

        // Collections.sort takes the default natural sorting order which is 
        // defined as part of the compareTo method.
        Collections.sort(movieList);
        movieList.stream().forEach(m->System.out.print(m.name + " "));
    }
    
}
