package racingcar

import kotlin.random.Random

class RaceStage(
    val cars: List<Car>
) {

    init {
        require(cars.isNotEmpty()) { "경주에 참여하는 자동차는 1개 이상이어야 합니다." }
    }

    companion object {
        fun create(carCount: Int): RaceStage = RaceStage(
            List(carCount) { Car() }
        )
    }

    fun racing(): RaceStage = RaceStage(
        cars.map { car -> car.race(Random.Default) }
    )
}
