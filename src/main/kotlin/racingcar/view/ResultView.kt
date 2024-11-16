package racingcar.view

object ResultView {
    private const val FORWARD_STATUS = "-"
    private const val SHOW_RACING_START_MESSAGE = "실행 결과"

    fun showRacingStart() {
        println()
        println(SHOW_RACING_START_MESSAGE)
    }

    fun showRacingResult(forwardStatus: MutableMap<Int, Int>) {
        forwardStatus.forEach { (status) ->
            println(FORWARD_STATUS.repeat(status))
        }
        println()
    }
}
