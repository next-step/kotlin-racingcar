package step3

import step3.entity.RacingCar
import step3.view.InputView
import step3.view.OutputView
import step3.workflow.GetWinners
import step3.workflow.Race
import kotlin.random.Random

class Main(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(LINE_SYMBOL),
    private val race: Race = Race { Random.nextInt(MIN_VALUE, MAX_VALUE) > MOVE_FORWARD_VALUE },
    private val getWinners: GetWinners = GetWinners(),
) {
    operator fun invoke() {
        val raceCondition = inputView()
        var racingCars = makeCars(raceCondition.nameOfCars)
        repeat(raceCondition.numberOfLabs) {
            racingCars = doLabs(racingCars)
            outputView.forLabs(racingCars)
        }
        val winners = getWinners(racingCars)
        outputView.forWinners(winners)
    }

    private fun makeCars(nameOfCars: List<String>): List<RacingCar> =
        nameOfCars.map { RacingCar(name = it) }

    private fun doLabs(cars: List<RacingCar>): List<RacingCar> =
        cars.map { race(it) }

    companion object {
        private const val LINE_SYMBOL = "-"
        private const val MAX_VALUE = 10
        private const val MIN_VALUE = 0
        private const val MOVE_FORWARD_VALUE = 4
    }
}

fun main() {
    Main().invoke()
}
