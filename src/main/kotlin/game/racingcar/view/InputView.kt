package game.racingcar.view

object InputView {

    fun getInputFromConsole(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readLine()?.toInt() ?: throw IllegalArgumentException("자동차 대수는 0 이상의 숫자로 입력해야 합니다.")
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrials = readLine()?.toInt() ?: throw IllegalArgumentException("시도할 횟수는 0 이상의 숫자로 입력해야 합니다.")
        return Pair(numberOfCars, numberOfTrials)
    }
}
