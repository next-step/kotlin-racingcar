package study.step4.model

private const val CAR_NAME_DELIMITERS = ","
private const val RACING_CAR_NAME_MAX_LENGTH = 5

object RacingCarNameGenerator {
    fun racingCarNameValid(carNameList: List<String>) {
        carNameList.forEach {
            require(it.isNotEmpty()) { "자동차 이름은 빈값을 입력 할 수  없습니다" }
            require(it.trim().length <= RACING_CAR_NAME_MAX_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다" }
        }
        val distinctRacingCarNamesList = carNameList.distinct()
        require(carNameList.size == distinctRacingCarNamesList.size) { "중복된 이름을 사용할 수 없습니다" }
        require(distinctRacingCarNamesList.isNotEmpty()) { "참가 자동차 수는 0보다 커야 합니다" }
    }

    fun convertCarNamesList(racingCarNames: String): List<String> =
        racingCarNames.split(CAR_NAME_DELIMITERS)
            .map { it.trim() }
            .toList()
}
