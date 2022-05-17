package racingcar.domain

import racingcar.common.RandomDigitGenerator

interface Driver {
    fun drive(): MovementCommand
}

object RandomDriver : Driver {
    override fun drive(): MovementCommand {
        val command = RandomDigitGenerator.nextDigit()
        return MovementCommand.of(command)
    }
}

class PreparedDriver(
    _preparedCommands: List<Int>
) : Driver {

    private val preparedCommands = ArrayDeque(_preparedCommands)

    override fun drive(): MovementCommand {
        check(preparedCommands.isNotEmpty()) { "준비된 명령을 모두 사용했습니다" }
        return MovementCommand.of(preparedCommands.removeFirst())
    }
}
