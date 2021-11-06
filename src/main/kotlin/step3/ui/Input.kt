package step3.ui

import java.util.InputMismatchException

object Input {
    fun getCountOfCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: throw InputMismatchException("지원하지 않는 포맷입니다.")
    }

    fun getNumberOfRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw InputMismatchException("지원하지 않는 포맷입니다.")
    }
}
