package racingcar.app.console

import racingcar.domain.Car

class OutputView {

    fun writeMessage(message: String) {
        println(message)
    }

    fun writeCars(cars: List<Car>) {
        cars.forEach { println(MOVE_SIGN.repeat(it.position)) }
    }

    fun writeLineBreak() {
        println()
    }

    companion object {
        const val MOVE_SIGN = "-"
    }
}
