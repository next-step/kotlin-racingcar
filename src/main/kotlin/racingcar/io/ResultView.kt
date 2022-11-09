package racingcar.io

object ResultView {
    private const val MARK = "-"

    enum class Message(val context: String) {
        CAR_COUNT("자동차 대수는 몇 대인가요?"),
        PLAY_COUNT("시도할 횟수는 몇 회인가요?"),
        RESULT("실행 결과");
    }

    fun printMessage(message: Message) =
        println(message.context)

    fun printResult(distance: Int) =
        println(MARK.repeat(distance.inc()))

    fun printNewLine() =
        println()
}
