package step3.ui

import step3.dto.GameSetting

object InputView {
    fun input(): GameSetting {
        return GameSetting.Builder()
            .inputCarCount(inputCarCount())
            .inputMoveCount(inputMoveCount())
            .build()
    }

    private fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val inputCarCount = readLine()!!.toInt()
        require(inputCarCount > 0) { "1 이상 입력해주세요." }
        return inputCarCount
    }

    private fun inputMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputMoveCount = readLine()!!.toInt()
        require(inputMoveCount > 0) { "1 이상 입력해주세요." }
        return inputMoveCount
    }
}
