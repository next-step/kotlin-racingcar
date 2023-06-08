package step3.domain.game

import step3.domain.car.Car
import step3.domain.car.CarFactory
import step3.domain.formula.BasicRuleMoveFormula
import step3.domain.formula.MoveFormula
import step3.domain.generator.NumberGenerator
import step3.domain.generator.RandomNumberGenerator
import step3.model.RaceGameErrorCode
import java.util.concurrent.atomic.AtomicInteger

data class RaceGame(
    private val raceGameInfo: RaceGameInfo,
    private val moveFormula: MoveFormula = BasicRuleMoveFormula,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator,
) {

    private val cars: List<Car>
    private val round: AtomicInteger

    init {
        val carCount = raceGameInfo.carCount

        require(value = carCount >= MINIMUM_CAR_COUNT) {
            RaceGameErrorCode.INVALID_CAR_COUNT.message("$MINIMUM_CAR_COUNT $carCount")
        }

        val createCars: MutableList<Car> = mutableListOf()

        repeat(times = carCount) {
            createCars.add(
                element = CarFactory.createCar(moveFormula = moveFormula),
            )
        }

        cars = createCars
        round = AtomicInteger(raceGameInfo.round)
    }

    @Throws(IllegalStateException::class)
    fun race(): List<Int> {
        check(value = round.get() > MINIMUM_ROUND) {
            RaceGameErrorCode.NOT_REMAINING_ROUND.message(round.toString())
        }

        round.decrementAndGet()

        return cars.map {
            it.move(
                value = numberGenerator.generate(),
            )
        }
    }

    fun isProgress(): Boolean = round.get() > MINIMUM_ROUND

    companion object {
        private const val MINIMUM_ROUND = 0
        private const val MINIMUM_CAR_COUNT = 1
    }
}
