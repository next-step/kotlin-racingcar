package week1.racing.view

import week1.racing.domain.GameRound
import week1.racing.domain.RacingCar

class ResultView {
    fun printRounds(gameRounds: List<GameRound>) {
        println("\n실행 결과\n")
        gameRounds.forEach { round ->
            buildMessageForEachRound(round)
            println()
        }
    }

    fun printWinners(winners: List<RacingCar>) {
        val winnerMessage = winners.joinToString { ", " }
        println("$winnerMessage 가 최종 우승 했습니다.")
    }

    private fun buildMessageForEachRound(round: GameRound) {
        fun buildMessage(
            carName: String,
            positionCount: Int,
        ) = buildString {
            append(carName)
            append(" : ")
            append(PATH_DASH.repeat(positionCount))
        }

        round.records.forEach { (carName, positionCount) ->
            val message = buildMessage(carName, positionCount)
            println(message)
        }
    }

    companion object {
        private const val PATH_DASH = "-"
    }
}
