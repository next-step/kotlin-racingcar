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
        raceResultRecord.carPositions
            .forEach { carPositionRecord ->
                val carName = carPositionRecord.name
                val skidMark = "-".repeat(carPositionRecord.position)

                println("$carName : $skidMark")
            }

        println()
    }
}
