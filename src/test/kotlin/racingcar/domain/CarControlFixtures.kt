package racingcar

import racingcar.domain.CarControl

class InputCarControl(private val input: Int) : CarControl {
    override fun power(): Int = input
}

object ForwardCarControl : CarControl {
    override fun power(): Int = 4
}

object StopCarControl : CarControl {
    override fun power(): Int = 3
}
