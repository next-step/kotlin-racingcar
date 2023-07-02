package racingcar.service.strategy

import kotlin.random.Random

fun interface NumberGenerateStrategy {
    fun generate(): Int
}

class RandomNumberZeroToNineGenerate : NumberGenerateStrategy {
    override fun generate(): Int {
        return Random.nextInt(10)
    }
}
