package patterns.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {

    @Test
    public void whenBridgePatternInvoked_thenConfigSuccess() {
        //a square with red color
        Shape square = new Rectangle(new Blue());

        assertEquals(square.draw(), "Square drawn. blue");
    }
}
