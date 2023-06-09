package study.racinggame.race

import study.racinggame.race.reader.InputReader

class InputView {

    private var carCount: Int = 0
    private var raceTryCnt: Int = 0
    private lateinit var reader: InputReader

    fun initInputView(inputReader: InputReader): InputView {
        reader = inputReader
        carCount = getIntInput("자동차 대수는 몇 대인가요?", "자동차 대수를 숫자로 입력해주세요.")
        raceTryCnt = getIntInput("시도할 횟수는 몇 회인가요?", "시도할 횟수를 숫자로 입력해주세요.")
        println()
        return this
    }

    private fun getIntInput(prompt: String, errorMsg: String): Int {
        println(prompt)
        val input = reader.raedLine()
        require(input?.toIntOrNull() != null) { errorMsg }
        return input!!.toInt()
    }

    fun carCount(): Int {
        return carCount
    }

    fun raceTryCnt(): Int {
        return raceTryCnt
    }
}
