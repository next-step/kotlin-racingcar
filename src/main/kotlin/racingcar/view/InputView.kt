package racingcar.view

import racingcar.dto.InputDTO

object InputView {

    private const val MINIMUM_INPUT = 0
    private const val CAR_CONDITION = "자동차 대수"
    private const val TRIALS_CONDITION = "시도할 횟수"

    fun input(): InputDTO {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val cars = readCars(CAR_CONDITION)

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

    private fun readCars(condition: String): List<String> {
        val res: List<String> = readLine()?.run { split(",") } ?: throw IllegalArgumentException("자동차 이름을 잘못 입력했습니다.")
        if (res.any { it.length > 5 }) {
            throw Exception("문자열의 길이가 6자 이상인 항목이 있습니다.")
        }
        if (res.size == MINIMUM_INPUT) {
            throw IllegalArgumentException("${condition}는 1 이상이어야 합니다.")
        }
        return res
    }
}
