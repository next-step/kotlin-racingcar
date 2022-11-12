package racingcar.io

import racingcar.Car

object OutputView {
    fun showMovingCarResult(car: Car) {
        print("${car.name} : ")
        repeat(car.currentPosition) { print("-") }
        println()
    }

    fun nextTurn() {
        println()
    }
}
