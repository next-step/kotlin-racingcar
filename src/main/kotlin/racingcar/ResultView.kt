package racingcar

object ResultView {
    fun printGameResult(gameResultRecord: GameResultRecord) {
        println("실행 결과")

        gameResultRecord.raceResults
            .forEach {
                printRaceResult(it)
            }

        gameResultRecord.winners?.let { winners ->
            printWinners(winners)
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

    private fun printWinners(winners: Winners) {
        val winnersName = winners.names.joinToString()

        println("${winnersName}가 최종 우승했습니다.")
    }
}
