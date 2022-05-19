package study.racingCar.view

object InputView {

    fun inputCarNum(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun inputMovingTryNum(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
