package edu.byu.cs.sonar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {

    private CustomFileReader sut;

    @BeforeEach
    void setUp() {
        sut = new CustomFileReader("readMe1.txt");
    }

    @Test
    void testHowManyWordsInFile() throws FileNotFoundException {
        assertEquals(4, sut.howManyWordsInFile(), "There should be 4 words in readMe1.txt");
    }

    @Test
    void testReturnThatWord() throws FileNotFoundException {
        assertEquals("I", sut.returnThatWord(1), "The first word should be I in readMe1.txt");
    }

    @Test
    void testFindNewWord() throws FileNotFoundException {
        sut.findNewWord("C");
        assertEquals("Computer ", sut.getNewSentence(), "Computer should be found when C queried");
    }

    @Test
    void testGetNewSentence() {
        assertEquals("", sut.getNewSentence(), "New sentence should be empty initially");
    }

    @Test
    void setNewSentence() {
        String betterSentence = "New Sentence.";
        sut.setNewSentence(betterSentence);
        assertEquals(betterSentence, sut.getNewSentence());
    }

    @Test
    void getCountTest() {
        assertEquals(0, sut.getCount());
    }

    @Test
    void hashTest() {
        sut.hashCode();
    }

    @Test
    void getPathTest() {
        String s = sut.getPath();
        assertNotNull(s);
    }

    @Test
    void equalsTest() {
        boolean bool = sut.equals(sut);
        assertTrue(bool);
    }

    @Test
    void equalsDifferentClass() {
        assertNotEquals(sut, "readMe1.txt");
    }

    @Test
    void equalsDifferentSentence() {
        CustomFileReader other = new CustomFileReader("readMe1.txt");
        other.setNewSentence("Something else");
        assertNotEquals(sut, other);
    }

    @Test
    void equalsDifferentCount() throws FileNotFoundException {
        CustomFileReader other = new CustomFileReader("readMe1.txt");
        other.howManyWordsInFile();
        assertNotEquals(sut, other);
    }
}