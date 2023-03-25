package helper;

import java.util.List;
import java.util.Random;

public class CommonHelper {

    public <T> T getRandomElementFromList(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
