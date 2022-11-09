package racingcar.io

object InputView {
    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
