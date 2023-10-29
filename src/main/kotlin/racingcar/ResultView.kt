package racingcar

object ResultView {
    fun printGameResult(gameResultRecord: GameResultRecord) {
        println("실행 결과")

        gameResultRecord.raceResults
            .forEach {
                printRaceResult(it)
            }
    }

    private fun printRaceResult(raceResultRecord: RaceResultRecord) {
        raceResultRecord.positions
            .forEach { position ->
                val skidMark = "-".repeat(position)

                println(skidMark)
            }

        println()
    }
}
