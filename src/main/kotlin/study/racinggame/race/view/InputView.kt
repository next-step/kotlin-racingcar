package study.racinggame.race.view

import study.racinggame.race.reader.InputReader

class InputView {

    private var carNames = listOf<String>()
    private var raceTryCnt: Int = 0
    private lateinit var reader: InputReader

    fun initInputView(inputReader: InputReader): InputView {
        reader = inputReader
        carNames = getCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        raceTryCnt = getIntInput("시도할 횟수는 몇 회인가요?", "시도할 횟수를 숫자로 입력해주세요.")
        println()
        return this
    }

    private fun getCarNames(prompt: String): List<String> {
        println(prompt)
        val input = reader.raedLine()
        return input.split(",")
    }

    private fun getIntInput(prompt: String, errorMsg: String): Int {
        println(prompt)
        val input = reader.raedLine()
        require(input.toIntOrNull() != null) { errorMsg }
        return input.toInt()
    }

    fun carNames(): List<String> {
        return carNames
    }

    fun raceTryCnt(): Int {
        return raceTryCnt
    }
}
