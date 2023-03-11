package at.ac.fhcampuswien.fhmdb.fhmdb;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void list(){
        List<Genre> movieList = new ArrayList<>();
        List<Genre> correctList = new ArrayList<>();
        movieList.add(ACTION);
        correctList.add(ACTION);
        assertEquals(correctList,movieList);
    }

}