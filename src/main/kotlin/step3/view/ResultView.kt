package step3.view

object ResultView {

    private const val START_RACE_GAME = "실행 결과"
    private const val CAR_POSITION_MARK = "-"
    private const val EMPTY = ""
    private const val ZERO = 0

    fun printStartGame() = print(message = START_RACE_GAME)

    fun printCarsPosition(carsPosition: List<Int>) {
        carsPosition.forEach {
            println(it.mark())
        }

        println()
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun Int.mark(): String = ZERO.rangeUntil(other = this)
        .fold(initial = EMPTY) { acc, _ -> acc + CAR_POSITION_MARK }
}
