package study.step3.race

import study.step3.race.reader.InputReader

class InputView(
    private val inputReader: InputReader,
) {

    private var carCount: Int = 0
    private var raceTryCnt: Int = 0

    fun setCommand() {
        carCount = getIntInput("자동차 대수는 몇 대인가요?", "자동차 대수를 숫자로 입력해주세요.")
        raceTryCnt = getIntInput("시도할 횟수는 몇 회인가요?", "시도할 횟수를 숫자로 입력해주세요.")
        println()
    }

    private fun getIntInput(prompt: String, errorMsg: String): Int {
        println(prompt)
        val input = inputReader.raedLine()
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
