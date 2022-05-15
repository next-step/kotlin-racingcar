package racingcar.view

object InputView {
    fun readCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readInput(readLine())
    }

    fun readNumOfTrials(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readInput(readLine()).toInt()
    }

    private fun readInput(inputStr: String? = null): String {
        require(!inputStr.isNullOrBlank()) { "입력값이 비어있어요." }
        return inputStr
    }
}
