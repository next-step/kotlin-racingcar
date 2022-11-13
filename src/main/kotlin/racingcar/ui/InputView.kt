package racingcar.ui

object InputView {

    fun getCarNumber(): Int {
        println("자동차 대수는 몇 대인가요?")
        return getNumber()
    }

    fun getTrialNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getNumber()
    }

    private fun getNumber(): Int = readLine()?.toIntOrNull()?.let {
        require(it > 0) { IllegalArgumentException("0보다 큰 수를 입력해주세요.") }
        it
    } ?: throw IllegalArgumentException("숫자를 입력해주세요.")
}
