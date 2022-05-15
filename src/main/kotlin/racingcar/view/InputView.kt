package racingcar.view

object InputView {
    fun readNumOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readInput(readLine())
    }

    fun readNumOfTrials(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readInput(readLine())
    }

    private fun readInput(inputStr: String? = null): Int {
        require(!inputStr.isNullOrBlank()) { "입력값이 비어있어요."}
        return inputStr.toInt()
    }
}
