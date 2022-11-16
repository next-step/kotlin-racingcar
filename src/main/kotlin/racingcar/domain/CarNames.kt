package racingcar.domain

class CarNames(text: String) {

    private val carNames: List<CarName>

    init {
        require(text.isNotBlank()) { "자동차 이름 목록은 빈 값을 입력할 수 없습니다." }
        carNames = text.split(CAR_NAME_SPLIT_DELIMITER).map { CarName(it) }.toList()
    }

    fun getCarNames(): List<CarName> {
        return carNames
    }

    companion object {
        private const val CAR_NAME_SPLIT_DELIMITER = ","
    }
}
