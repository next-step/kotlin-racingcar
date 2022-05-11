package racingcar.common

object RandomCommandGenerator {

    val COMMAND_RANGE = 0..9

    fun nextCommand(): Int {
        return COMMAND_RANGE.random()
    }
}
