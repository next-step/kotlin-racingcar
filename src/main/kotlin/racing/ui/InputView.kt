package racing.ui

import racing.dto.GameSetting

object InputView {
    fun input(): GameSetting {
        return GameSetting.Builder()
            .inputCarNames(inputCarNames())
            .inputMoveCount(inputMoveCount())
            .build()
    }

    private fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNameString = readLine()!!
        val inputCarNames = inputCarNameString.split(",")
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .distinct()
        require(inputCarNames.isNotEmpty()) { "자동차 이름을 한 대 이상 입력해주세요." }
        return inputCarNames
    }

    private fun inputMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputMoveCount = readLine()!!.toInt()
        require(inputMoveCount > 0) { "1 이상 입력해주세요." }
        return inputMoveCount
    }
}
