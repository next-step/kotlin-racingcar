package study.racing.ui

import study.racing.entity.Race

class ResultView(
    private val race: Race
) {
    fun printResult() {
        println("경주 결과")
        race.rounds
            .joinToString(ROUND_SEPARATOR) { round ->
                round.record
                    ?.joinToString(RACING_CAR_SEPARATOR) { position ->
                        "-".repeat(position)
                    }
                    ?: throw IllegalStateException("끝나지 않은 라운드가 있습니다.")
            }.let(::println)
    }

    companion object {
        private const val ROUND_SEPARATOR = "\n\n"
        private const val RACING_CAR_SEPARATOR = "\n"
    }
}