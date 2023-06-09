package step3.domain.game

import step3.domain.car.Car
import step3.domain.formula.MoveFormula
import step3.model.RaceGameErrorCode
import java.util.concurrent.atomic.AtomicInteger

data class RaceGame(
    private val cars: List<Car>,
    private val round: AtomicInteger,
    private val moveFormula: MoveFormula,
) {

    init {
        val carCount = cars.size

        require(value = carCount >= MINIMUM_CAR_COUNT) {
            RaceGameErrorCode.INVALID_CAR_COUNT.message("$MINIMUM_CAR_COUNT $carCount")
        }
    }

    @Throws(IllegalStateException::class)
    fun race(): List<Int> {
        check(value = round.get() > MINIMUM_ROUND) {
            RaceGameErrorCode.NOT_REMAINING_ROUND.message(round.toString())
        }

        round.decrementAndGet()

        return cars.map {
            it.move(moveFormula = moveFormula)
        }
    }

    fun isProgress(): Boolean = round.get() > MINIMUM_ROUND

    companion object {
        private const val MINIMUM_ROUND = 0
        private const val MINIMUM_CAR_COUNT = 1
    }
}
