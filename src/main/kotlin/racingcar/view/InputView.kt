package racingcar.view

class InputView(
    private val carNumberQuestion: String = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
    private val trialsQuestion: String = "시도할 횟수는 몇 회인가요?"
) {
    fun receiveValues(): InputValues {
        return InputValues(
            carNames = readNames(),
            trials = readInt(trialsQuestion)
        )
    }

    private fun readNames(): List<String> {
        println(carNumberQuestion)
        return readLine()!!
            .trim()
            .split(NAME_DELIMITER)
    }

    private fun readInt(question: String): Int {
        println(question)
        return readLine()!!.toInt()
    }

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
