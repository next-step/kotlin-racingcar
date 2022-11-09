package racingcar.etc

object ResultView {

    private const val DISTANCE_CHARACTER = "-"

    fun racing(results: List<RacingResultDTO>) {
        results.forEach {
            println(DISTANCE_CHARACTER.repeat(it.distance))
        }
        println()
    }
}
