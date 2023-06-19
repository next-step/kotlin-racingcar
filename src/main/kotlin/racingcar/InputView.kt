package racingcar

object InputView {
    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toIntOrNull() ?: throw NullPointerException("number of cars was null")
    }

    fun getNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toIntOrNull() ?: throw NullPointerException("number of rounds was null")
    }
}
