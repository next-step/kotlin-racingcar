package racingcar

import kotlin.random.Random

private const val INIT_ROUND = 0

private const val MOVE_ROUND = 1

class RaceStage(
    val cars: List<Car>,
    val round: Int
) {

    private val nextRound
        get() = round + MOVE_ROUND

    init {
        require(cars.isNotEmpty()) { "경주에 참여하는 자동차는 1개 이상이어야 합니다." }
        require(round >= INIT_ROUND) { "음수 라운드는 없습니다." }
    }

    companion object {
        fun create(carCount: Int): RaceStage = RaceStage(
            (0 until carCount).map { Car() }, INIT_ROUND
        )
    }

    fun racing(): RaceStage = RaceStage(
        cars.map { car -> car.race(Random.Default) }, nextRound
    )
}
