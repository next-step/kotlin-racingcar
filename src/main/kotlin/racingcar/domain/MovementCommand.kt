package racingcar.domain

enum class MovementCommand(
    val power: Int
) {
    FORWARD(1),
    WAIT(0);

    companion object {

        private const val MIN_COMMAND = 0
        private const val MIN_MOVABLE_COMMAND = 4
        private const val MAX_COMMAND = 9

        fun of(command: Int): MovementCommand {
            require(command in MIN_COMMAND..MAX_COMMAND) { "명령은 $MIN_COMMAND 와 $MAX_COMMAND 사이의 숫자이어야 합니다." }
            return if (command >= MIN_MOVABLE_COMMAND) FORWARD else WAIT
        }
    }
}
