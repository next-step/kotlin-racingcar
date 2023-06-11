package racing.generator

import java.util.Random

class DefaultRandomMoveCheckGenerator(
    private val fixNumber: Int? = null
) : RandomMoveCheckGenerator {
    override fun moveCheck(bound: Int): Boolean {

        fixNumber?.let {
            return fixNumber >= 4
        }

        return Random().nextInt(bound) >= 4
    }
}
