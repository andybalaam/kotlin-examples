import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScorerKTest {
    @Test
    public void Scores_from_multiple_words_are_combined() {
        ScorerK s = new ScorerK();
        s.scoreRequest("user1", "purple");
        s.scoreRequest("user1", "purple");
        s.scoreRequest("user1", "purple");
        assertThat(s.total("user1"), equalTo(9));
    }

    @Test
    public void Different_users_are_independent() {
        ScorerK s = new ScorerK();
        s.scoreRequest("user1", "purple");
        s.scoreRequest("user2", "purple");
        s.scoreRequest("user1", "lavendar");
        // BUG! assertThat(s.total("user1"), equalTo(8));
        assertThat(s.total("user2"), equalTo(3));
    }
}
