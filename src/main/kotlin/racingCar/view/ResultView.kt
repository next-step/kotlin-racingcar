package racingCar.view

import racingCar.etc.Message
import racingCar.model.Car

/**
 * 결과를 출력하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class ResultView {
    fun printResult(carList: List<Car>) {
        println(Message.PrintingMessage.EXECUTION_RESULT)
        carList.forEach {
            repeat(it.position) {
                print("-")
            }
            println()
        }
    }
}
