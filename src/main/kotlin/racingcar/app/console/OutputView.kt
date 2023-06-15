package racingcar.app.console

import racingcar.domain.RacingResult

class OutputView {

    fun writeMessage(message: String) {
        println(message)
    }

    fun writeCars(racingResult: RacingResult) {
        racingResult.cars.forEach { println(MOVE_SIGN.repeat(it.position)) }
        if (!racingResult.end) writeLineBreak()
    }

    private fun writeLineBreak() {
        println()
    }

    companion object {
        const val MOVE_SIGN = "-"
    }
}
