package study.racingcar.ui

object InputView {
    private const val INPUT_CAR_NAMES_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_TRY_COUNT_COMMENT = "시도할 횟수는 몇 회인가요?"
    private const val CAR_NAME_SEPARATOR = ","
    private const val CAR_NAME_MAXIMUM_LENGTH = 5

    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES_COMMENT)
        val carNames = readLine() ?: throw IllegalArgumentException("잘못된 입력값 입니다.")
        require(carNames.isNotBlank()) {
            "자동차 이름이 입력되지 않았습니다."
        }
        return toCarNameList(carNames)
    }

    fun inputTryCount(): Int {
        println(INPUT_TRY_COUNT_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException("잘못된 입력값 입니다.")
    }

    fun toCarNameList(carNames: String): List<String> {
        val carNameList = carNames.split(CAR_NAME_SEPARATOR)
        validateCarNameList(carNameList)
        return carNameList
    }

    fun validateCarNameList(carNameList: List<String>) {
        carNameList.forEach {
            require(it.isNotBlank()) {
                "차량의 이름이 잘못 입력되었습니다.($it)"
            }
            require(it.length <= CAR_NAME_MAXIMUM_LENGTH) {
                "차량의 이름은 최대 ${CAR_NAME_MAXIMUM_LENGTH}자 까지만 가능합니다."
            }
        }
    }
}
