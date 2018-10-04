import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThingShortcutsTest {
    @Test
    public void Can_make_things_and_get_their_properties() {
        ThingShortcuts t = new ThingShortcuts("na", "da");
        assertThat(t.getName(), equalTo("na"));
        assertThat(t.getDesc(), equalTo("da"));
    }

    @Test
    public void Identical_ThingShortcutss_are_equal() {
        ThingShortcuts t1 = new ThingShortcuts("a", "b");
        ThingShortcuts t2 = new ThingShortcuts("a", "b");
        assertThat(t1, equalTo(t2));
        assertThat(t2, equalTo(t1));
    }

    @Test
    public void Different_ThingShortcutss_are_not_equal() {
        ThingShortcuts t1 = new ThingShortcuts("a", "b");
        ThingShortcuts t2 = new ThingShortcuts("a", "X");
        ThingShortcuts t3 = new ThingShortcuts("X", "b");
        ThingShortcuts t4 = new ThingShortcuts("b", "a");
        assertThat(t1, not(equalTo(t2)));
        assertThat(t2, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t3)));
        assertThat(t3, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t4)));
        assertThat(t4, not(equalTo(t1)));
    }

    @Test
    public void Identical_things_have_the_same_hashcode() {
        ThingShortcuts t1 = new ThingShortcuts("a", "b");
        ThingShortcuts t2 = new ThingShortcuts("a", "b");
        assertThat(t1.hashCode(), equalTo(t2.hashCode()));
    }

    @Test
    public void Different_ThingShortcutss_have_different_hashcodes() {
        // Note: could fail in a correct implementation!
        ThingShortcuts t1 = new ThingShortcuts("a", "b");
        ThingShortcuts t2 = new ThingShortcuts("a", "X");
        ThingShortcuts t3 = new ThingShortcuts("X", "b");
        ThingShortcuts t4 = new ThingShortcuts("b", "a");
        assertThat(t1.hashCode(), not(equalTo(t2.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t3.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t4.hashCode())));
    }

    @Test
    public void ThingShortcutss_can_be_converted_to_strings() {
        ThingShortcuts t1 = new ThingShortcuts("a", "b");
        assertThat(t1.toString(), equalTo("ThingShortcuts(name=a, desc=b)"));
    }
}