package racing.view

object AskingView {
    const val JOIN_CAR_COUNT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val TRY_GAME_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"

    fun askCounting(question: String): Int {
        println(question)
        return readln().orEmpty().toInt()
    }

    fun askCarName(question: String): String {
        println(question)
        return readln().orEmpty()
    }
}
