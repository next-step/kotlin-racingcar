package racing.components

import kotlin.random.Random

class RandomWrapperImpl : RandomWrapper {
    override fun nextInt(until: Int) = Random.nextInt(until)
}
