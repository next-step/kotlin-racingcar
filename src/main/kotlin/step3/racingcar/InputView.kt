package step3.racingcar

object InputView {

    fun carCount(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun movementCount(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readln().toInt()
    }
}
