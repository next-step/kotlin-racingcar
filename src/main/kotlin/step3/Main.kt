package step3

import step3.entity.RacingCar
import step3.view.InputView
import step3.view.OutputView
import step3.workflow.Race
import kotlin.random.Random

class Main(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(LINE_SYMBOL),
    private val race: Race = Race { Random.nextInt(0, 10) > 4 },
) {
    operator fun invoke() {
        val raceCondition = inputView()
        var racingCars = makeCars(raceCondition.numberOfCars)
        (0 until raceCondition.numberOfLabs).forEach {
            racingCars = doLabs(racingCars)
            outputView(racingCars)
        }
    }

    private fun makeCars(numberOfCars: Int): List<RacingCar> =
        (0 until numberOfCars).map { RacingCar() }

    private fun doLabs(cars: List<RacingCar>): List<RacingCar> =
        cars.map { race(it) }

    companion object {
        private val LINE_SYMBOL = "-"
    }
}

fun main() {
    Main().invoke()
}
