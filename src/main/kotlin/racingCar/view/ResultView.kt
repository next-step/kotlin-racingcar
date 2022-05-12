package racingCar.view

import racingCar.constants.Message
import racingCar.model.RaceResult

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
        print("${raceResult.winners.joinToString { it }}가 최종 우승했습니다.")
    }
}
