package racingcar.view

import racingcar.domain.Score
import racingcar.domain.Scores

object ResultView {
    private const val MOVE_EXPRESSION = "-"
    private const val RESULT_MESSAGE = "실행결과"
    private const val WINNER_RESULT_POSTFIX_MESSAGE = "가 최종 우승하였습니다"
    private const val WINNER_NAME_DELIMITER = ","
    private const val BLANK_PREFIX_MESSAGE = ""

    fun printResult(allRoundScore: List<Scores>) {
        println()
        println(RESULT_MESSAGE)
        for (scores in allRoundScore) {
            printScore(scores)
        }
        printWinner(allRoundScore)
    }

    private fun printScore(scores: Scores) {
        repeat(scores.size()) {
            printExpression(scores.score(it))
        }
        println()
    }

    private fun printExpression(score: Score) {
        print("${score.carName} :")
        repeat(score.point) {
            print(MOVE_EXPRESSION)
        }
        println()
    }

    private fun printWinner(allRoundScore: List<Scores>) {
        val lastScores = allRoundScore[allRoundScore.lastIndex]
        val winners = lastScores.findWinner()
        val winnerNameWithDelimiter =
            winners.names.joinToString(
                WINNER_NAME_DELIMITER,
                BLANK_PREFIX_MESSAGE,
                WINNER_RESULT_POSTFIX_MESSAGE,
            ) { it.name }
        println(winnerNameWithDelimiter)
    }
}
