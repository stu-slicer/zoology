package com.nology.zoology.data;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalBuilder;
import com.nology.zoology.animal.AnimalType;
import com.nology.zoology.animal.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVZooDataLoaderTest {

    public static final String LION_LINE = "3,lion,Rex,10,42,3,55,true";

    private Lion lion;

    private CSVZooDataLoader target;

    @TempDir
    private File workingPath;
    private File workingFile;
    @BeforeEach
    void setUp() {

        File workingFile = new File( workingPath, "zoology-data-file.csv");
        System.out.println(workingFile.getAbsolutePath());

        this.workingFile = workingFile;

        target = new CSVZooDataLoader( workingFile.getAbsolutePath() );

        lion = (Lion) AnimalBuilder.animal("Rex")
                .withId(3)
                .withType(AnimalType.lion)
                .withAge(10)
                .withPopularity(42)
                .withStars(3)
                .withHunger((short) 55)
                .withPettable(true)
                .build();
    }

    @Test
    void saveAnimalData() {
        target.saveAnimalData( List.of( lion ) );

        List<String> lines = loadLinesFromFile(this.workingFile);

        assertEquals( LION_LINE, lines.get(0) );

    }

    @Test
    void loadAnimalData() {
        saveLinesToFile( workingFile, List.of(LION_LINE) );

        List<Animal> animals = target.loadAnimalData();
        Lion lion = (Lion) animals.get(0);
        System.out.println(animals);
        assertNotNull( lion );

        assertEquals( 3, lion.getId() );
        assertEquals( "Rex", lion.getName() );
        assertEquals( 10, lion.getAge() );
        assertEquals( 42, lion.getPopularity() );
        assertEquals( 3, lion.getStars() );
        assertEquals( 55, lion.getHunger() );
        assertTrue( lion.isPettable() );
    }

    private List<String> loadLinesFromFile(File fileToRead) {
        try {
            List<String> lines = Files.readAllLines( fileToRead.toPath() );
            return lines;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    private void saveLinesToFile(File fileToWrite,  List<String> lines) {
        try {
            Files.write( fileToWrite.toPath(), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}