package racingcar

import number.Numbers
import printer.InputView

object Reception {
    fun receiveNumberOfCar(): Int {
        InputView.printInputNumberOfCar()
        return Numbers.toInt(readLine()!!)
    }

    fun receiveNumberOfAttempts(): Int {
        InputView.printInputNumberOfAttempts()
        return Numbers.toInt(readLine()!!)
    }
}
