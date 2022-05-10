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
        raceResults.forEach {
            print(it.resultOutput)
            println()
        }
    }
}
