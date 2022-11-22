package study.racing.ui

import study.racing.domain.entity.Race

class ResultView(
    private val race: Race
) {
    fun printResult() {
        println("경주 결과")
        printRoundResult()
        printRaceResult()
    }

    private fun printRoundResult() = race.rounds
        .joinToString(ROUND_SEPARATOR) { round ->
            round.records
                ?.joinToString(RACING_CAR_SEPARATOR) { record ->
                    "${record.name} : ${"-".repeat(record.position)}"
                }
                ?: throw IllegalStateException("끝나지 않은 라운드가 있습니다.")
        }
        .let(::println)

    private fun printRaceResult() = race
        .getWinner()
        .joinToString(", ") { it.name }
        .let { "${it}가 최종 우승했습니다." }
        .let(::println)

    companion object {
        private const val ROUND_SEPARATOR = "\n\n"
        private const val RACING_CAR_SEPARATOR = "\n"
    }
}