package racing.ui

/**
 * @author tae-heon.song<taeheon.song@linecorp.com>
 * @since 2021. 02. 28.
 */
object ResultView {

    private const val SYMBOL_ONE_STEP = "-"
    private const val NOTICE_RESULT_START = "실행결과"

    fun printResultNotice() {
        println(NOTICE_RESULT_START)
    }

    fun printAllPosition(positions: List<Int>) {
        for (position in positions) {
            printSinglePosition(position)
        }
        println()
    }

    private fun printSinglePosition(position: Int) {
        for (i in 1..position) {
            print(SYMBOL_ONE_STEP)
        }
        println()
    }
}
