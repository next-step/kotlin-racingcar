package study.racingcar.ui

object InputView {

    fun getCarNames(): List<String> {
        val input = getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return input.split(",").map { it.trim() }
    }

    fun getCarCount(): Int {
        return getInputInt("자동차 대수는 몇 대 인가요?")
    }

    fun getMoveCount(): Int {
        return getInputInt("시도할 회수는 몇 회 인가요?")
    }

    private fun getInputString(prompt: String): String {
        printPrompt(prompt)
        return readlnOrNull() ?: ""
    }

    private fun getInputInt(prompt: String): Int {
        printPrompt(prompt)
        return readlnOrNull()?.toInt() ?: 0
    }

    private fun printPrompt(prompt: String) {
        println(prompt)
    }
}
