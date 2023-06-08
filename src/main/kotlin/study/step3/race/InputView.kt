package study.step3.race

import study.step3.race.mock.InputReader

class InputView(
    private val inputReader: InputReader,
) {

    private var carStorage: IntArray = IntArray(0)
    private var raceTryCnt: Int = 0

    fun setCommand() {
        carStorage = IntArray(getIntInput("자동차 대수는 몇 대인가요?", "자동차 대수를 숫자로 입력해주세요."))
        raceTryCnt = getIntInput("시도할 횟수는 몇 회인가요?", "시도할 횟수를 숫자로 입력해주세요.")
        println()
    }

    private fun getIntInput(prompt: String, errorMsg: String): Int {
        println(prompt)
        val input = inputReader.raedLine()
        require(input?.toIntOrNull() != null) { errorMsg }
        return input!!.toInt()
    }

    fun carStorage(): IntArray {
        return carStorage
    }

    fun raceTryCnt(): Int {
        return raceTryCnt
    }
}
