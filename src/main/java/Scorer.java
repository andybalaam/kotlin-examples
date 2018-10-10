import java.util.HashMap;
import java.util.Map;

public class Scorer {
    private static final Map<String, Integer> wordValues =
        new HashMap<>();
    static {
        wordValues.put("purple", 3);
        wordValues.put("lavender", 5);
        wordValues.put("amethyst", 50);
    }

    private final Map<String, Integer> scores =
        new HashMap<>();

    void scoreRequest(String user, String path) {
        scores.merge(
            user,
            wordValues.get(path),
            Integer::sum
        );
    }

    public int total(String user) {
        return scores.get(user);
    }
}
