package racingcar.view

object InputView {
    fun receiveRequest(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readln().toIntOrNull() ?: throw IllegalArgumentException("자동차 대수가 올바르지 않습니다.")

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTries = readln().toIntOrNull() ?: throw IllegalArgumentException("시도할 회수가 올바르지 않습니다.")

        return Pair(numberOfCars, numberOfTries)
    }
}
