package racingcar.domain

import racingcar.service.RandomGenerator
import racingcar.service.RangeRandomGenerator

interface MoveStrategy {
    fun move(car: Car)
}

class Over4MoveStrategy(
    private val randomGenerator: RandomGenerator = RangeRandomGenerator()
) : MoveStrategy {

    companion object{
        private const val MOVE_CRITERION = 4
    }

    override fun move(car: Car) {
        if (randomGenerator.generate() > MOVE_CRITERION) {
            car.move()
        }
    }
}
