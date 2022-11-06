package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

class Track(private val random: RandomStrategy) {

    fun play() {
        ResultView.printMessage(ResultView.Message.CAR_COUNT)
        val carCount = InputView.requestPositiveNumber()
        val cars: List<Car> = (1..carCount).map { Car() }

        ResultView.printMessage(ResultView.Message.PLAY_COUNT)
        val playCount = InputView.requestPositiveNumber()

        ResultView.printMessage(ResultView.Message.RESULT)
        this.start(playCount = playCount, cars = cars)
    }

    private fun start(playCount: Int, cars: List<Car>) =
        repeat(playCount) {
            this.move(cars)
            this.printResult(cars)
        }

    private fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            ResultView.printResult(car.position)
        }

        ResultView.printNewLine()
    }

    private fun move(cars: List<Car>) =
        cars.forEach { car ->
            car.move(this.random.generateInt())
        }
}
