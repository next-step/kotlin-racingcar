package racingcar.view

import racingcar.view.InputInspector.validateNames
import racingcar.view.InputInspector.validateRunCnt

object InputView {
    private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요 - 쉼표(,)를 기준으로 이름을 구분합니다"
    private const val ENTER_RUN_COUNT = "시도할 횟수는 몇 회인가요?"
    const val RE_ENTER_CAR_NAMES = "2개 이상 이름을 입력해주세요 (이름은 5자까지 허용됩니다)"
    const val RE_ENTER_NAMES_WITHIN_FIVE_LEN = "이름은 5자까지 허용됩니다. 다시 입력해주세요"
    const val RE_ENTER_RUN_COUNT = "1 이상의 숫자를 입력해주세요"
    private const val CAR_NAME_DELIMITER = ","

    fun getCarNames(): List<String> {
        ENTER_CAR_NAMES.also(::println)

        val names = splitIntoNames(readLine())

        return validateNames(names)
    }

    fun getRunCnt(): Int {
        ENTER_RUN_COUNT.also(::println)

        return validateRunCnt(readRunCnt())
    }

    fun readRunCnt() = readLine()?.trim()?.toIntOrNull()

    fun splitIntoNames(line: String?): List<String> {
        var names = line
        while (names.isNullOrBlank()) {
            print("입력되지 않았습니다 - ")
            RE_ENTER_CAR_NAMES.also(::println)
            names = readLine()
        }
        return names.trim().split(CAR_NAME_DELIMITER).filter { it.isNotBlank() }
    }
}
