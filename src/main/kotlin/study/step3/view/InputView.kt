package study.step3.view

import study.step2.isInt

object InputView {

    fun inputRacingCarInfo(): Pair<Int, Int> {
        println("자동차 대수는 몇 대인가요?")
        val numberCars: String? = readLine()
        requireNotNull(numberCars) { "숫자를 입력해야 합니다" }
        require(numberCars.isInt()) { "숫자만 입력 가능합니다" }

        println("시도할 횟수는 몇 회인가요?")
        val repeatRace: String? = readLine()
        requireNotNull(repeatRace) { "숫자를 입력해야 합니다" }
        require(repeatRace.isInt()) { "숫자만 입력 가능합니다" }

        return numberCars.toInt() to repeatRace.toInt()
    }
}
