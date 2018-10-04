import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThingTest {
    @Test
    public void Can_make_things_and_get_their_properties() {
        Thing t = new Thing("na", "da");
        assertThat(t.getName(), equalTo("na"));
        assertThat(t.getDesc(), equalTo("da"));
    }

    @Test
    public void Identical_Things_are_equal() {
        Thing t1 = new Thing("a", "b");
        Thing t2 = new Thing("a", "b");
        assertThat(t1, equalTo(t2));
        assertThat(t2, equalTo(t1));
    }

    @Test
    public void Different_Things_are_not_equal() {
        Thing t1 = new Thing("a", "b");
        Thing t2 = new Thing("a", "X");
        Thing t3 = new Thing("X", "b");
        Thing t4 = new Thing("b", "a");
        assertThat(t1, not(equalTo(t2)));
        assertThat(t2, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t3)));
        assertThat(t3, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t4)));
        assertThat(t4, not(equalTo(t1)));
    }

    @Test
    public void Identical_things_have_the_same_hashcode() {
        Thing t1 = new Thing("a", "b");
        Thing t2 = new Thing("a", "b");
        assertThat(t1.hashCode(), equalTo(t2.hashCode()));
    }

    @Test
    public void Different_Things_have_different_hashcodes() {
        // Note: could fail in a correct implementation!
        Thing t1 = new Thing("a", "b");
        Thing t2 = new Thing("a", "X");
        Thing t3 = new Thing("X", "b");
        Thing t4 = new Thing("b", "a");
        assertThat(t1.hashCode(), not(equalTo(t2.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t3.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t4.hashCode())));
    }

    @Test
    public void Things_can_be_converted_to_strings() {
        Thing t1 = new Thing("a", "b");
        assertThat(t1.toString(), equalTo("Thing(name=a, desc=b)"));
    }
}