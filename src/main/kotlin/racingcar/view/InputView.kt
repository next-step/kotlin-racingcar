package racingcar.view

object InputView {
    fun getNumberOfCarInput(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readLine()?.toIntOrNull() ?: 0
    }

    fun getTotalCountOfRoundInput(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readLine()?.toIntOrNull() ?: 0
    }
}
