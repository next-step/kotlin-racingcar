package racingcar.view

import racingcar.model.Participant

object ResultView {

    fun printRacingProcess(racingCarNames: List<String>, racingHistory: List<Int>) {
        println("실행 결과")

        val chunkedRacingHistory = racingHistory.chunked(racingCarNames.size)
        printRacingStep(racingCarNames, chunkedRacingHistory)
    }

    fun printRacingWinner(participant: Participant) {
        println("${participant.findWinner().joinToString { it.name }}가 최종 우승했습니다.")
    }

    private fun printRacingStep(racingCarNames: List<String>, chunkedRacingHistory: List<List<Int>>) {
        repeat(chunkedRacingHistory.size) { tryCnt ->
            repeat(racingCarNames.size) { racingCnt ->
                println("${racingCarNames[racingCnt]} : ${"-".repeat(chunkedRacingHistory[tryCnt][racingCnt])}")
            }
            println()
        }
    }
}
