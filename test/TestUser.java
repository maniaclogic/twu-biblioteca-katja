import com.twu.biblioteca.Book;
import com.twu.biblioteca.Media;
import com.twu.biblioteca.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestUser {

    User user1 = new User("123-1234", "hsf3");
    Book book1 = Book.createBook("Super", "Cool", 100);

    @Test
    public void checkedOutTest() {
        ArrayList<String> array = new ArrayList<String>();
        array.add(book1.toString());

        user1.checkedOut(book1);
        assertThat(user1.getCheckedOutMedia(), is(array));
    }

}
