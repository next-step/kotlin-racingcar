package racingcar.domain.model

class CarNames(val carNameList: List<String> = emptyList()) {

    init {
        require(carNameList.isNotEmpty()) { "자동차 이름이 있어야 합니다" }
    }
}
