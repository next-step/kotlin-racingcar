package racingCar.view

import racingCar.etc.Message
import racingCar.model.RaceResult

/**
 * 결과를 출력하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class ResultView {
    fun printResult(raceResults: List<RaceResult>) {
        println(Message.PrintingMessage.EXECUTION_RESULT)
        raceResults.forEach {
            print(it.resultOutput)
            println()
        }
    }
}
