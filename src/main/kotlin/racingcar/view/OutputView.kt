package racingcar.view

import racingcar.car.Car
import racingcar.racing.Racing.moveCarForward

object OutputView {
    private fun printCarStatus(cars: List<Car>) {
        cars.forEach { car ->
            var track = StringBuilder()
            for (i: Int in 0 until car.status) {
                track.append("-")
            }
            println(track)
        }
    }

    fun resultView(cars: List<Car>, tryCount: Int) {
        println("실행 결과")
        var resultCars = cars
        for (i: Int in 0 until tryCount) {
            printCarStatus(resultCars)
            resultCars = moveCarForward(resultCars)
            println()
        }
    }
}
