package racingcar.impl

import racingcar.InputView

class InputViewImpl : InputView {
    override fun readInputNumber(): Int {
        val value = readLine()!!
        return value.toInt()
    }
}
