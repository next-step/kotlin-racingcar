package racing.domain.game

import racing.domain.car.Car
import racing.domain.formula.MoveFormula
import racing.model.RaceGameErrorCode

class RaceGame(
    private val cars: List<Car>,
    private var round: Int,
    private val moveFormula: MoveFormula,
) {

    init {
        val carCount = cars.size

        require(value = carCount >= MINIMUM_CAR_COUNT) {
            RaceGameErrorCode.INVALID_CAR_COUNT.message("$MINIMUM_CAR_COUNT $carCount")
        }
    }

    @Synchronized
    @Throws(IllegalStateException::class)
    fun race(raceResultProcess: (List<RaceGameResult>) -> Unit) {
        check(value = round > MINIMUM_ROUND) {
            RaceGameErrorCode.NOT_REMAINING_ROUND.message(round.toString())
        }

        while (round > MINIMUM_ROUND) {
            raceResultProcess(
                cars.map {
                    RaceGameResult(
                        name = it.name,
                        position = it.move(moveFormula = moveFormula),
                    )
                }
            )

            round--
        }
    }

    fun currentHeadOfRace(): List<String> = cars.maxOf { it.position }
        .run {
            cars.filter { it.position == this }
                .map { it.name }
        }

    companion object {
        private const val MINIMUM_ROUND = 0
        private const val MINIMUM_CAR_COUNT = 1
    }
}
