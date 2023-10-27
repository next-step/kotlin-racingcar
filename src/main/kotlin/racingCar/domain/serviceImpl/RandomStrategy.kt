package racingCar.domain.serviceImpl

import racingCar.domain.service.MoveStrategy
import kotlin.random.Random

class RandomStrategy: MoveStrategy {

    override fun isMove(): Boolean {
        val randomValue = Random.nextInt(LIMIT_NUMBER)
        return randomValue >= FILTER_NUMBER
    }

    companion object {
        private const val LIMIT_NUMBER = 10
        private const val FILTER_NUMBER = 4
    }
}
