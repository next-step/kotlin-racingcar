package racingcar.domain.model

class CarNames(private val carNameList: List<String> = emptyList()) {

    init {
        require(carNameList.isNotEmpty()) { "자동차 이름이 있어야 합니다" }
    }

    fun map(action: (String) -> CarRacer): List<CarRacer> {
        return carNameList.map(action)
    }
}
