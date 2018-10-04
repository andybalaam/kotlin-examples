import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThingKTest {
    @Test
    public void Can_make_things_and_get_their_properties() {
        ThingK t = new ThingK("na", "da");
        assertThat(t.getName(), equalTo("na"));
        assertThat(t.getDesc(), equalTo("da"));
    }

    @Test
    public void Identical_ThingKs_are_equal() {
        ThingK t1 = new ThingK("a", "b");
        ThingK t2 = new ThingK("a", "b");
        assertThat(t1, equalTo(t2));
        assertThat(t2, equalTo(t1));
    }

    @Test
    public void Different_ThingKs_are_not_equal() {
        ThingK t1 = new ThingK("a", "b");
        ThingK t2 = new ThingK("a", "X");
        ThingK t3 = new ThingK("X", "b");
        ThingK t4 = new ThingK("b", "a");
        assertThat(t1, not(equalTo(t2)));
        assertThat(t2, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t3)));
        assertThat(t3, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t4)));
        assertThat(t4, not(equalTo(t1)));
    }

    @Test
    public void Identical_things_have_the_same_hashcode() {
        ThingK t1 = new ThingK("a", "b");
        ThingK t2 = new ThingK("a", "b");
        assertThat(t1.hashCode(), equalTo(t2.hashCode()));
    }

    @Test
    public void Different_ThingKs_have_different_hashcodes() {
        // Note: could fail in a correct implementation!
        ThingK t1 = new ThingK("a", "b");
        ThingK t2 = new ThingK("a", "X");
        ThingK t3 = new ThingK("X", "b");
        ThingK t4 = new ThingK("b", "a");
        assertThat(t1.hashCode(), not(equalTo(t2.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t3.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t4.hashCode())));
    }

    @Test
    public void ThingKs_can_be_converted_to_strings() {
        ThingK t1 = new ThingK("a", "b");
        assertThat(t1.toString(), equalTo("ThingK(name=a, desc=b)"));
    }
}