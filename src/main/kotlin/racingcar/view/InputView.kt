package racingcar.view

class InputView {

    private fun read(description: String): String {
        println(description)
        return readLine()!!
    }

    fun carNames(): List<String> {
        val rawCarNames = read("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return rawCarNames.split(NAME_DELIMITER)
    }

    fun attemptCount() = read("시도할 횟수는 몇 회인가요?").toInt()

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
