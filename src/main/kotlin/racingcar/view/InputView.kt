package racingcar.view

import racingcar.dto.InputDTO

object InputView {

    private const val MINIMUM_INPUT = 0
    private const val CAR_CONDITION = "자동차 대수"
    private const val TRIALS_CONDITION = "시도할 횟수"

    fun input(): InputDTO {
        println("${CAR_CONDITION}는 몇 대인가요?")
        val cars = read(CAR_CONDITION)

        println("${TRIALS_CONDITION}는 몇 회인가요?")
        val trials = read(TRIALS_CONDITION)

        return InputDTO(cars, trials)
    }

    private fun read(condition: String): Int {

        val res = kotlin.runCatching {
            val num = readLine()?.toInt() ?: MINIMUM_INPUT
            num
        }.getOrElse {
            throw NumberFormatException("숫자를 입력해주세요.")
        }
        if (res == MINIMUM_INPUT) {
            throw IllegalArgumentException("${condition}은 1 이상이어야 합니다.")
        }
        return res
    }
}
