package racingcar.io

object InputView {
    fun getCommandLineInput(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readLine()?.toInt() ?: throw IllegalArgumentException("자동차 대수를 입력해주세요.")

        println("시도할 횟수는 몇 회인가요?")
        val numberOfAttempts = readLine()?.toInt() ?: throw IllegalArgumentException("시도할 횟수를 입력해주세요.")

        return Pair(numberOfCars, numberOfAttempts)
    }
}
