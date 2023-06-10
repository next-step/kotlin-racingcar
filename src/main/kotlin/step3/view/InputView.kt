package step3.view

import step3.RacingRequirement

object InputView {
    fun askRequirement(): RacingRequirement {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("숫자를 입력해 주세요")
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrials = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("숫자를 입력해 주세요")

        return RacingRequirement(
            numberOfCars = numberOfCars,
            numberOfTrials = numberOfTrials
        )
    }
}
