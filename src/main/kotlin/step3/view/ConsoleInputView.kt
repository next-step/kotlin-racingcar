package step3.view

import step3.RacingRequirement

class ConsoleInputView : InputView {
    override fun askRequirement(): RacingRequirement {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNameString = readlnOrNull() ?: throw IllegalArgumentException("이름을 입력해야 합니다")
        require(CAR_NAME_INPUT_PATTERN.matches(carNameString)) { "이름을 쉼표 기준으로 구분해서 입력해주세요." }

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrials = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("숫자를 입력해 주세요")

        return RacingRequirement(
            carNames = carNameString.split(","),
            numberOfTrials = numberOfTrials
        )
    }

    companion object {
        private val CAR_NAME_INPUT_PATTERN = Regex("""\w+(,\w+)*""")
    }
}
