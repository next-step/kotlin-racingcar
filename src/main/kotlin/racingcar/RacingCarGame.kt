package racingcar

import racingcar.View.InputView

fun main() {

    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    println("\n실행 결과")
    val driverList = List(carCount) { Driver(Car()) }

    repeat(tryCount) {
        driverList.forEach {
            val isMovable = (0..9).random() >= 4
            it.drive(isMovable)

            println(it.getMoveResult())
        }
        println("")
    }
}