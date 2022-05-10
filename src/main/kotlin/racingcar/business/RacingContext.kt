package racingcar.business

import racingcar.domain.Car
import racingcar.domain.collection.Cars
import racingcar.property.Property
import racingcar.utils.RandomGenerator

class RacingContext(
    private val numOfPlayer: Int,
    private val numOfMove: Int,
    private val random: RandomGenerator
) {
    init {
        require(numOfPlayer > 0 && numOfMove > 0)
    }

    private val result = mutableListOf<List<Int>>()

    private val cars: Cars = Cars(
        List(numOfPlayer) {
            Car(
                Property().FORWARD_THRESHOLD,
                Property().FORWARD_DISTANCE_RANGE,
                random
            )
        }
    )

    fun play(): List<List<Int>> {
        repeat(numOfMove) {
            cars.run()
            result.add(cars.getPosition())
        }
        return result
    }
}
