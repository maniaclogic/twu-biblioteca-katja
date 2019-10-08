import com.twu.biblioteca.BibliotecaApp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BibliotecaAppTest {
    @Test
    public void testGreet () {
        BibliotecaApp app = new BibliotecaApp();
        assertThat(app.greet(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }
}