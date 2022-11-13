package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.Rank
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController {

    fun race() {
        val cars: List<Car> = this.loadCar()
        val playCount: Int = this.getPlayCount()
        val finishedRacingCars: List<Car> = this.playGame(playCount, cars)
        this.rank(finishedRacingCars)
    }

    private fun loadCar(): List<Car> {
        ResultView.printMessage(ResultView.Message.CAR_NAMES_WITH_COMMA)
        val names: List<String> = InputView.requestString(DELIMITERS)
        return names.map { Car(name = it) }
    }

    private fun getPlayCount(): Int {
        ResultView.printMessage(ResultView.Message.PLAY_COUNT)
        return InputView.requestPositiveNumber()
    }

    private fun playGame(playCount: Int, cars: List<Car>): List<Car> {
        ResultView.printMessage(ResultView.Message.RESULT)
        val racingGame = RacingGame(cars, RandomForward())
        return racingGame.play(playCount, printResult)
    }

    private fun rank(finishedRacingCars: List<Car>) {
        val winners: String = Rank.getWinnerNames(finishedRacingCars)
        ResultView.printMessage(winners, ResultView.Message.WINNER)
    }

    companion object {
        private const val DELIMITERS = ","

        private val printResult: (List<Car>) -> Unit = { cars ->
            cars.forEach { car ->
                ResultView.printResult(name = car.name, distance = car.position)
            }

            ResultView.printNewLine()
        }
    }
}

fun main() {
    RacingController().race()
}
