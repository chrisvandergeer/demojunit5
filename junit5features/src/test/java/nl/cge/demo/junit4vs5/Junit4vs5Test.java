package nl.cge.demo.junit4vs5;

import org.junit.jupiter.api.*;

public class Junit4vs5Test {

    public Junit4vs5Test() {
        System.out.println("Constuctor");
    }

//    @BeforeClass
    @BeforeAll
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

//    @Before
    @BeforeEach
    public void before() {
        System.out.println("before");
    }

    @Test
    public void testMe() {
        System.out.println("test");
    }

//    @After
    @AfterEach
    public void tearDown() {
        System.out.println("after");
    }

//    @AfterClass
    @AfterAll
    public static void afterClass() {
        System.out.println("afterClass");
    }

}
