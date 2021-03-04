package racingcar

import number.Numbers
import printer.InputView

object Reception {
    const val CAR_NAME_DELIMITERS = ","

    fun receiveNumberOfAttempts(): Int {
        InputView.printInputNumberOfAttempts()
        return Numbers.toInt(readLine()!!)
    }

    fun receiveCarNames(): List<String> {
        InputView.printInputCarNames()

        return readLine()!!.split(CAR_NAME_DELIMITERS)
    }
}
