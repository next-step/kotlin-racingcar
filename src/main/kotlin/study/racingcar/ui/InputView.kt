package study.racingcar.ui

object InputView {
    private const val INPUT_CAR_NAMES_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_TRY_COUNT_COMMENT = "시도할 횟수는 몇 회인가요?"
    private const val CAR_NAME_SEPARATOR = ","

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
        return carNames.split(CAR_NAME_SEPARATOR)
    }
}
