package racing.domain.common

import racing.domain.utils.RandomNumberStrategy
import kotlin.random.Random

class RandomNumberMaker : RandomNumberStrategy {
    override fun getRandomNumber() = Random.nextInt(RANDOM_NUMBER_START, RANDOM_NUMBER_END)

    companion object {
        private const val RANDOM_NUMBER_START = 0
        private const val RANDOM_NUMBER_END = 10
    }
}
