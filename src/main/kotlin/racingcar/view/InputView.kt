package racingcar.view

import racingcar.view.InputInspector.validNames
import racingcar.view.InputInspector.validate
import racingcar.view.InputInspector.validateRunCnt

object InputView {
    private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요 (쉼표(,)를 기준으로 이름을 구분합니다)"
    private const val ENTER_RUN_COUNT = "시도할 횟수는 몇 회인가요?"
    const val ENTER_CAR_NAMES_AGAIN = "2개 이상의 이름을 입력해주세요 (이름은 5자까지 허용됩니다)"
    const val ENTER_RUN_COUNT_AGAIN = "1 이상의 숫자를 입력해주세요"
    private const val CAR_NAME_DELIMITER = ","

    fun getCarNames(): List<String> {
        ENTER_CAR_NAMES.also(::println)

        validate(readCarNames(readLine()))

        return validNames
    }

    fun getRunCnt(): Int {
        ENTER_RUN_COUNT.also(::println)

        return validateRunCnt(readRunCnt())
    }

    fun readRunCnt() = readLine()?.trim()?.toIntOrNull()

    fun readCarNames(line: String?): List<String> {
        var names = line
        while (names.isNullOrBlank()) {
            ENTER_CAR_NAMES_AGAIN.also(::println)
            names = readLine()
        }
        return names.trim().split(CAR_NAME_DELIMITER).filter { it.isNotBlank() }
    }
}
