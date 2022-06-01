import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void function() {
        Assertions.assertThrows(IllegalArgumentException.class,new Executable() {
            @Override
            public void execute() throws Throwable {
                SILab2.function(List.of());
            }
        });
        Assertions.assertThrows(IllegalArgumentException.class,new Executable() {
            @Override
            public void execute() throws Throwable {
                SILab2.function(List.of("0", "#", "0", "0", "#"));
            }
        });
        assertEquals(SILab2.function(List.of("0", "#", "0", "0", "0", "#", "#", "0", "#")), List.of("1", "#", "2", "1", "2", "#", "#", "2", "#"));
    }
}