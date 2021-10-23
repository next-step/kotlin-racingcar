package racingcar.ui

import racingcar.domain.BulletinBoard

const val LINE_FEED = "\n"
const val DELIMITER = ","

class RacingCarView(private val view: RacingCarScoreView = RacingCarScoreView()) {
    fun names() = nameInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

    fun laps() = lapInput("시도할 횟수는 몇 회인가요?")

    fun output(result: BulletinBoard) {
        println("실행 결과")
        println(view.display(result))
        println("${view.showWinner(result.winners)}가 최종 우승했습니다.")
    }

    private fun verifyNameInput(input: String?): List<String> {
        require(!input.isNullOrBlank()) { "null 또는 빈 문자열을 입력으로 사용할 수 없습니다." }
        return input.split(DELIMITER)

    }

    private fun verifyLapInput(input: String?): Int {
        require(!input.isNullOrBlank()) { "null 또는 빈 문자열을 입력으로 사용할 수 없습니다." }
        require(input.isInteger()) { "숫자만 입력값으로 사용할 수 있습니다. " }
        return input.toInt()
    }

    private fun String.isInteger() = when (this.toIntOrNull()) {
        null -> false
        else -> true
    }

    private fun nameInput(message: String): List<String> {
        println(message)
        return verifyNameInput(readLine())
    }

    private fun lapInput(message: String): Int {
        println(message)
        return verifyLapInput(readLine())
    }
}
