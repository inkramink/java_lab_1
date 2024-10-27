import org.container.Container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testSingleElementConstructor() {
        Container singleElementContainer = new Container("1");
        assertEquals(1, singleElementContainer.get_lenght());
        assertEquals("1", singleElementContainer.get_value(1));
    }

    @Test
    void testGetValue() {
        container.add("1");
        container.add("2");
        assertEquals("1", container.get_value(1));
        assertEquals("2", container.get_value(2));
    }

    @Test
    void testGetLength() {
        container.add("1");
        container.add("2");
        assertEquals(2, container.get_lenght());
    }

    @Test
    void testToString() {
        container.add("1");
        container.add("2");
        String expected = "Container:\n1 2 ";
        assertEquals(expected, container.toString());
    }

    @Test
    void testHashCode() {
        container.add("1");
        container.add("2");
        int expectedHashCode = 53 * "1".hashCode() + 24 * "2".hashCode() + 211;
        assertEquals(expectedHashCode, container.hashCode());
    }

    @Test
    void testEquals() {
        Container container1 = new Container("1");
        Container container2 = new Container("1");
        assertTrue(container1.equals(container2));

        container2.add("2");
        assertFalse(container1.equals(container2));
    }

    @Test
    void testAddTo() {
        container.add_to(1, "1");
        container.add_to(2, "2");
        container.add_to(1, "0");
        assertEquals("0", container.get_value(1));
        assertEquals("1", container.get_value(2));
        assertEquals("2", container.get_value(3));
    }

    @Test
    void testAdd() {
        container.add("1");
        container.add("2");
        assertEquals("1", container.get_value(1));
        assertEquals("2", container.get_value(2));
    }

    @Test
    void testRemove() {
        container.add("1");
        container.add("2");
        container.add("3");

        container.remove(2);
        assertEquals("1", container.get_value(1));
        assertEquals("3", container.get_value(2));

        container.remove(1);
        assertEquals("3", container.get_value(1));

        container.remove(1);
        assertEquals(0, container.get_lenght());
    }
}