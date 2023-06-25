package racingcar.service.strategy

import kotlin.random.Random

interface NumberGenerateStrategy {
    fun generate(): Int
}

class RandomNumberZeroToNineGenerate : NumberGenerateStrategy {
    override fun generate(): Int {
        return Random.nextInt(10)
    }
}

class NumberZeroGenerate : NumberGenerateStrategy {
    override fun generate(): Int {
        return 0
    }
}

class NumberNineGenerate : NumberGenerateStrategy {
    override fun generate(): Int {
        return 9
    }
}
