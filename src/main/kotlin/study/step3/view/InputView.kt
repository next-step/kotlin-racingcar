package study.step3.view

import study.step2.isInt

class InputView {

    companion object {
        fun input(): Pair<Int, Int> {
            println("자동차 대수는 몇 대인가요?")
            val numberCars: String = readLine()!!
            require(numberCars.isInt()) { "숫자만 입력 가능합니다" }

            println("시도할 횟수는 몇 회인가요?")
            val repeatRace: String = readLine()!!
            require(repeatRace.isInt()) { "숫자만 입력 가능합니다" }

            return numberCars.toInt() to repeatRace.toInt()
        }
    }
}
