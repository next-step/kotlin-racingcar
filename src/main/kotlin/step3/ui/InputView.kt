package step3.ui

import step3.GameSetting

object InputView {
    fun input(): GameSetting {
        println("자동차 대수는 몇 대인가요?")
        val inputCarCount = readLine()!!.toInt()

        println("시도할 횟수는 몇 회인가요?")
        val inputMoveCount = readLine()!!.toInt()

        return GameSetting.builder()
            .inputCarCount(inputCarCount)
            .inputMoveCount(inputMoveCount)
            .build()
    }
}
