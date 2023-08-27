import com.itsthelittlethings.store_manager.UnableToSaveEmployeeAvailabilityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnableToSaveEmployeeAvailabilityExceptionTest {

    @Test
    void unableToSaveEmployeeAvailabilityExceptionContainsMessage() {
        final var message = "Unable to save employee availability";

        try {
            throw new UnableToSaveEmployeeAvailabilityException(message);
        } catch (UnableToSaveEmployeeAvailabilityException unableToSaveEmployeeAvailabilityException) {
            Assertions.assertEquals(message, unableToSaveEmployeeAvailabilityException.getMessage());
        }
    }

    @Test
    void unableToSaveEmployeeAvailabilityExceptionIsThrowable() {
        Assertions.assertThrows(UnableToSaveEmployeeAvailabilityException.class, () -> {
            throw new UnableToSaveEmployeeAvailabilityException("Unable to save employee availability");
        });
    }
}
