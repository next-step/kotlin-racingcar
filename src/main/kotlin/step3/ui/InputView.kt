package step3.ui

import step3.dto.GameSetting

object InputView {
    fun input(): GameSetting {
        return GameSetting.builder()
            .inputCarCount(inputCarCount())
            .inputMoveCount(inputMoveCount())
            .build()
    }

    private fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toInt()
    }

    private fun inputMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
