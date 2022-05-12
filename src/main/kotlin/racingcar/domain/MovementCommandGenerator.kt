package racingcar.domain

import racingcar.common.RandomCommandGenerator

interface MovementCommandGenerator {
    fun generateMovement(): MovementCommand
}

object RandomMovementCommandGenerator : MovementCommandGenerator {
    override fun generateMovement(): MovementCommand {
        val command = RandomCommandGenerator.nextCommand()
        return MovementCommand.of(command)
    }
}
