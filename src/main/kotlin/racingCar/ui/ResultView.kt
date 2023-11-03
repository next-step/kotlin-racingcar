package racingCar.ui

import racingCar.domain.RaceResult

object ResultView {

    private const val RESULT_MESSAGE = "실행 결과"
    private const val CAR_TRACK = "-"
    private const val RACE_RESULT_FORMAT = "%s : %s"
    private const val WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다."

    fun printRaceResult(roundResults: List<RaceResult.RoundResult>) {
        println(RESULT_MESSAGE)

        roundResults.forEach { result ->
            printResultByRound(result)
            print(System.lineSeparator())
            Thread.sleep(500) // 라운드 사이의 결과를 0.5초씩 딜레이시켜서 실시간으로 출력되는 것처럼 보이도록 만들기
        }
    }

    private fun printResultByRound(result: RaceResult.RoundResult) {
        result.results.forEach {
            val moveResult = CAR_TRACK.repeat(it.position)
            println(String.format(RACE_RESULT_FORMAT, it.name, moveResult))
        }
    }

    fun printWinners(winners: List<RaceResult.CarMoveResult>) {
        winners.joinToString(", ") { it.name }.also { name ->
            println(String.format(WINNER_MESSAGE_FORMAT, name))
        }
    }
}
