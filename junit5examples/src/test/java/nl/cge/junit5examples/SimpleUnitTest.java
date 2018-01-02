package nl.cge.junit5examples;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleUnitTest {

    public SimpleUnitTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    void initAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("BeforeEach");
    }

    @Test
    void testMe() {
        System.out.println("Test 1");
    }

    @Test
    void testMeToo() {
        System.out.println("Test 2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @AfterAll
    void tearAllDown() {
        System.out.println("AfterAll");
    }
}
