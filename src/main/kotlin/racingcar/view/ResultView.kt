package racingcar.view

import racingcar.common.ViewMessage

object ResultView {
    private const val FORWARD_STATUS = "-"

    fun showRacingStart() {
        println()
        println(ViewMessage.SHOW_RACING_START_MESSAGE.viewMessage)
    }

    fun showRacingResult(forwardStatus: MutableMap<Int, Int>) {
        forwardStatus.forEach { (status) ->
            println(FORWARD_STATUS.repeat(status))
        }
        println()
    }
}
