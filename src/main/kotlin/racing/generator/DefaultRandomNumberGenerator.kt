package racing.generator

import java.util.Random

class DefaultRandomNumberGenerator : RandomNumberGenerator {
    override fun nextInt(bound: Int): Int {
        return Random().nextInt(bound)
    }
}
