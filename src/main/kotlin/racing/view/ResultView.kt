package racing.view

object ResultView {

    private const val START_RACE_GAME = "실행 결과"
    private const val CAR_POSITION_MARK = "-"
    private const val EMPTY = ""
    private const val ZERO = 0

    private const val CAR_POSITION_SEPARATOR = ":"

    private const val FINAL_HEAD_OF_RACE_SEPARATOR = ", "
    private const val FINAL_HEAD_OF_RACE_SUFFIX_MESSAGE = "가 최종 우승했습니다."

    fun printStartGame() = println(message = START_RACE_GAME)

    fun printCarPositionResults(results: List<CarPositionResult>) {
        results.forEach {
            println("${it.name} $CAR_POSITION_SEPARATOR ${it.position.mark()}")
        }

        println()
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun Int.mark(): String = ZERO.rangeUntil(other = this)
        .fold(initial = EMPTY) { acc, _ -> acc + CAR_POSITION_MARK }

    fun printFinalHeadOfRace(headOfRaceCarNames: List<String>) =
        headOfRaceCarNames.joinToString { FINAL_HEAD_OF_RACE_SEPARATOR } + FINAL_HEAD_OF_RACE_SUFFIX_MESSAGE
}
