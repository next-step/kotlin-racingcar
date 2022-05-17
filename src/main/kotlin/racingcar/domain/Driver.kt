package racingcar.domain

import racingcar.common.RandomDigitGenerator

interface Driver {
    fun drive(): Int
}

object RandomDriver : Driver {
    override fun drive(): Int {
        val command = RandomDigitGenerator.nextDigit()
        return MovementCommand.of(command).power
    }
}
