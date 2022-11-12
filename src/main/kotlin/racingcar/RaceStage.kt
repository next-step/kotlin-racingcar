package racingcar

import java.util.Comparator.comparingInt

private const val START_VALUE = 0
private const val LIMIT_VALUE = 10

class RaceStage(
    val cars: List<Car>,
) {

    init {
        require(cars.isNotEmpty()) { "경주에 참여하는 자동차는 1개 이상이어야 합니다." }
    }

    companion object {
        fun create(carNames: List<String>): RaceStage = RaceStage(
            List(carNames.size) { index -> Car(carNames[index]) }
        )
    }

    fun racing(): RaceStage = RaceStage(
        cars.map { car -> car.race(RacingCarEngine.canMove(((START_VALUE until LIMIT_VALUE).random()))) }
    )

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxWithOrNull(comparingInt { it.pos }) ?: throw IllegalStateException("우승자가 없을 수 없어요.")

        return cars.filter { it.pos == winnerCar.pos }
    }
}
