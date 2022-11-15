package racingcar.view

object ResultView {
    private const val MARK = "-"

    enum class Message(val context: String) {
        CAR_NAMES_WITH_COMMA("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        WINNER("가 최종 우승했습니다."),
        PLAY_COUNT("시도할 횟수는 몇 회인가요?"),
        RESULT("실행 결과");
    }

    fun printMessage(message: Message) = println(message.context)

    fun printMessage(prefix: String, message: Message) = println("$prefix ${message.context}")

    fun printResult(name: String, distance: Int) {
        val totalDistance = MARK.repeat(distance.inc())

        println("$name : $totalDistance")
    }

    fun printNewLine() = println()
}
