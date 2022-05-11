package racingcar.business

import racingcar.domain.Car
import racingcar.domain.collection.Cars
import racingcar.property.Property
import racingcar.utils.NumberGenerator

class RacingGame(
    private val numOfPlayer: Int,
    private val numOfMove: Int,
    private val random: NumberGenerator
) {
    init {
        require(numOfPlayer > 0) {
            "플레이어는 조건은 최소 1명 이상입니다."
        }

        require(numOfMove > 0) {
            "이동 횟수 조건은 최소 1번 이상입니다."
        }
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
            result.add(cars.getPositions())
        }
        return result
    }
}
