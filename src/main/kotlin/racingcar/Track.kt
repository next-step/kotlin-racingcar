package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

class Track(private val random: FowardStrategy) {

    fun play() {
        ResultView.printMessage(ResultView.Message.CAR_NAMES_WITH_COMMA)
        val names: List<String> = InputView.requestString(DELIMITERS)
        val cars: List<Car> = names.map { Car(name = it) }

        ResultView.printMessage(ResultView.Message.PLAY_COUNT)
        val playCount: Int = InputView.requestPositiveNumber()

        ResultView.printMessage(ResultView.Message.RESULT)
        val finishedRacingCars: List<Car> = this.start(playCount, cars)
        val winners: String = this.getWinnerNames(finishedRacingCars)

        ResultView.printMessage(winners, ResultView.Message.WINNER)
    }

    private fun getWinnerNames(cars: List<Car>): String =
        this.getWinner(cars).joinToString(",") { it.name }

    fun getWinner(cars: List<Car>): List<Car> {
        val carsByPosition = cars.groupBy { it.position }
        val maxPosition: Int = carsByPosition.maxOf { it.key }

        return carsByPosition[maxPosition] ?: emptyList()
    }

    private fun start(playCount: Int, cars: List<Car>): List<Car> {
        if (playCount == 0) return cars

        val movedCars = this.move(cars)
        this.printResult(movedCars)

        return this.start(playCount.dec(), movedCars)
    }

    private fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            ResultView.printResult(name = car.name, distance = car.position)
        }

        ResultView.printNewLine()
    }

    private fun move(cars: List<Car>): List<Car> =
        cars.map { car ->
            car.move(this.random.generateInt())
        }

    companion object {
        private const val DELIMITERS = ","
    }
}

fun main() {
    Track { (0..9).random() }.play()
}
