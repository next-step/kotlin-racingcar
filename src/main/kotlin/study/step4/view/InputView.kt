package study.step4.view

import study.step2.isInt

object InputView {
    fun inputRacingCarInfo(): Pair<String, Int> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).?")
        val racingCarNames: String? = readLine()

        println("시도할 횟수는 몇 회인가요?")
        val repeatTime: String? = readLine()

        requireNotNull(racingCarNames) { "자동차 이름은 공백일 수 없습니다" }
        require(racingCarNames.trim().isNotEmpty()) { "자동차 이름은 빈공백일 수 없습니다" }
        requireNotNull(repeatTime) { "시도 횟수를 입력해야 합니다" }
        require(repeatTime.isInt()) { "숫자만 입력 가능합니다" }
        return racingCarNames to repeatTime.toInt()
    }
}
