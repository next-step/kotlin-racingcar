package racingcar.ui

import racingcar.domain.BulletinBoard

const val LINE_FEED = "\n"

class RacingCarView {
    fun cars() = input("자동차 대수는 몇 대인가요?")

    fun laps() = input("시도할 횟수는 몇 회인가요?")

    fun output(laps: Int, result: BulletinBoard) {
        println("실행 결과")
        println(result.display())
    }

    private fun verify(input: String?): Int {
        require(!input.isNullOrBlank()) { "null 또는 빈 문자열을 입력으로 사용할 수 없습니다." }
        require(input.isInteger()) { "숫자만 입력값으로 사용할 수 있습니다. " }
        return input.toInt()
    }

    private fun String.isInteger() = when (this.toIntOrNull()) {
        null -> false
        else -> true
    }

    private fun input(message: String): Int {
        println(message)
        return verify(readLine())
    }
}
