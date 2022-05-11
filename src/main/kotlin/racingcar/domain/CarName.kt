package racingcar.domain

data class CarName(val value: String) {

    init {
        require(value.isNotEmpty()) {
            "자동차 이름은 빈 문자열일 수 없습니다"
        }

        require(value.length <= CAR_NAME_LIMIT) {
            "자동차 이름은 ${CAR_NAME_LIMIT}자를 초과할 수 없습니다"
        }
    }

    companion object {
        private const val CAR_NAME_LIMIT = 5
        val DEFAULT_NAME: CarName = CarName("car")

        fun ofList(names: String, delimiter: String = ","): List<CarName> {
            return names.split(delimiter)
                .map(::CarName)
        }
    }
}
