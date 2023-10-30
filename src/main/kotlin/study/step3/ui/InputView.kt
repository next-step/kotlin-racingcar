package study.step3.ui

object InputView {
    fun getCarCount(): Int {
        return getInput("자동차 대수는 몇 대 인가요?")
    }

    fun getMoveCount(): Int {
        return getInput("시도할 회수는 몇 회 인가요?")
    }

    private fun getInput(prompt: String): Int {
        printPrompt(prompt)
        return readln().toInt()
    }

    private fun printPrompt(prompt: String) {
        println(prompt)
    }
}
