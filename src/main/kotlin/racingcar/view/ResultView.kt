package racingcar.view

import racingcar.constants.Message
import racingcar.model.RaceResult

/**
 * 결과를 출력하는 object
 * Created by Jaesungchi on 2022.05.07..
 */
object ResultView {
    fun printResult(raceResults: List<RaceResult>) {
        println(Message.PrintingMessage.EXECUTION_RESULT)
        printRunningRace(raceResults)
        printWinner(raceResults.last())
    }

    private fun printRunningRace(raceResults: List<RaceResult>) {
        raceResults.forEach {
            print(it.resultOutput)
            println()
        }
    }

    private fun printWinner(raceResult: RaceResult) {
        print(raceResult.winners.joinToString { it })
        print(Message.PrintingMessage.WINNER_WINNER_CHICKEN_DINNER)
    }
}
