package racingcar.view

class InputView {

    fun inputCarsCount(): Int {
        printInputCarCountMessage()
        return readln().toInt()
    }

    fun inputRoundCount(): Int {
        printInputTryCountMessage()
        return readln().toInt()
    }

    private fun printInputTryCountMessage() {
        println("시도할 회수는 몇 회 인가요?")
    }

    private fun printInputCarCountMessage() {
        println("자동차 대수는 몇 대 인가요?")
    }
}
