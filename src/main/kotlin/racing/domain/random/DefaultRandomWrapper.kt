package racing.domain.random

import kotlin.random.Random

class DefaultRandomWrapper : RandomWrapper {
    override fun nextInt(until: Int) = Random.nextInt(until)
}
