package racing

import racing.view.InputView
import racing.view.ResultView

class Racing {

    fun run() {

        InputView.printInputCar()
        val n = readLine()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")
        InputView.printInputCount()
        val count = readLine()?.toInt() ?: throw IllegalArgumentException("입력 값은 null 값이 올 수 없습니다")

        ResultView.printResult()
    }
}
