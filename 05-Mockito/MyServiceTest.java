import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Arrange: Create the Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Arrange: Stub the method to return predefined data
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Act: Pass the fake API into our service
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert: Check the result
        assertEquals("Mock Data", result);

        // 5. Verify: Ensure the service actually called the API (Exercise 2)
        verify(mockApi).getData();
        
        System.out.println("Mockito Test Passed: API was successfully mocked and verified!");
    }
}