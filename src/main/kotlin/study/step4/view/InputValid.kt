package study.step4.view

object InputValid {
    fun racingCarNameValid(carNameList: List<String>) {
        carNameList.forEach {
            require(it.trim().length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다" }
        }
        val distinctRacingCarNamesList = carNameList.distinct()
        require(carNameList.size == distinctRacingCarNamesList.size) { "중복된 이름을 사용할 수 없습니다" }
        require(distinctRacingCarNamesList.isNotEmpty()) { "참가 자동차 수는 0보다 커야 합니다" }
    }
}
