package racing.generator

import java.util.Random

class DefaultNumberGenerator : NumberGenerator {
    override fun nextInt(bound: Int): Int {
        return Random().nextInt(bound)
    }
}
