package step3.UI

object ResultView {
    private const val MOVE_HYPHEN = "-"
    fun show(count: Int) {
        printMoveHyphen(count)
        println()
    }

    private fun printMoveHyphen(count: Int) {
        for (i in 0 until count) {
            print(MOVE_HYPHEN)
        }
    }
}
