package step3.impl

import step3.InputView

class InputViewImpl : InputView {
    override fun readInputNumber(): Int {
        val value = readLine()!!
        return value.toInt()
    }
}
