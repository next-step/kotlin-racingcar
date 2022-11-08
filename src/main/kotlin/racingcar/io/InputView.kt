package racingcar.io

object InputView {
    fun getCommandLineInput(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readln().toInt()

        println("시도할 횟수는 몇 회인가요?")
        val numberOfAttempts = readln().toInt()

        return Pair(numberOfCars, numberOfAttempts)
    }
}
