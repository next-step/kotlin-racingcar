package racingcar

import racingcar.strategy.CarMoveStrategy
import java.util.Comparator.comparingInt

class RaceStage(
    val cars: List<Car>,
) {

    init {
        require(cars.isNotEmpty()) { "경주에 참여하는 자동차는 1개 이상이어야 합니다." }
    }

    companion object {
        fun create(carNames: List<String>): RaceStage = RaceStage(
            carNames.map { carName -> Car(carName) }
        )
    }

    fun racing(strategy: CarMoveStrategy): RaceStage = RaceStage(
        cars.map { car -> car.race(RacingCarEngine.canMove(strategy.generate())) }
    )

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxWithOrNull(comparingInt { it.pos }) ?: throw IllegalStateException("우승자가 없을 수 없어요.")
        return cars.filter { it.equalsPos(winnerCar) }
    }
}
