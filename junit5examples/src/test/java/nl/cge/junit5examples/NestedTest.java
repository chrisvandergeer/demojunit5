package nl.cge.junit5examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Gegeven een lijst")
public class NestedTest {

    private List<String> lijst;

    @BeforeEach
    public void setup() {
        lijst = new ArrayList<>();
    }

    @Nested
    @DisplayName("Wanneer nieuw geinstantieerd")
    class EmptyList {

        @Test
        @DisplayName("Dan bevat deze geen elementen")
        void nieuweLijstIsLeeg() {
            assertTrue(lijst.isEmpty());
        }

    }

    @Nested
    @DisplayName("Wanneer ik er Aap, Noot en Mies in stop")
    class FilledList {

        @BeforeEach
        void setup() {
            lijst.add("Aap");
            lijst.add("Noot");
            lijst.add("Mies");
        }

        @Test
        @DisplayName("Dan bevat de lijst 3 elementen")
        void testMetAapEnNoot() {
            assertEquals(3, lijst.size());
        }

        @Test
        @DisplayName("Dan is Noot het 2e element")
        void testNootIs2eElement() {
            assertEquals("Noot", lijst.get(1));
        }

        @Nested
        @DisplayName("Wanneer ik de lijst sorteer")
        class SortedList {

            @BeforeEach
            void setup() {
                Collections.sort(lijst);
            }

            @Test
            @DisplayName("Dan is Mies het 2e element")
            void testMiesIs2eElement() {
                assertEquals("Mies", lijst.get(1));
            }
        }
    }

}
