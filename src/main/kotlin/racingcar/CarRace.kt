package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.dto.CarSnapshot
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput
import racingcar.view.InputView
import racingcar.view.OutputView
import java.util.Random

class CarRace(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val random = Random()
        val countOfCars = inputView.askCountOfCars()
        val cars = Cars(List(countOfCars) { Car() })
        val countOfTrial = inputView.askCountOfTrial()
        println("실행결과")
        for (i in 0 until countOfTrial) {
            takeOneTrial(cars, random)
        }
    }

    private fun takeOneTrial(cars: Cars, random: Random) {
        cars.move { random.nextInt(10) * 10 >= 4 }
        val snapshots = cars.values.map(::CarSnapshot).toList()
        outputView.printCarPositions(snapshots)
        println()
    }
}

fun main() {
    val carRace = CarRace(ConsoleInput(), ConsoleOutput())
    carRace.run()
}
