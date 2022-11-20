package racingcar.domain

const val DEFAULT_LAB_COUNT = 5

data class Setting(val cars: List<Car>, val numberOfLab: Int = DEFAULT_LAB_COUNT) {
    init {
        require(numberOfLab >= 1) { "1보다 작은 정수를 입력할 수 없습니다" }
        require(cars.isNotEmpty()) { "자동차 이름이 최소한 하나는 있어야합니다" }
    }

    companion object {
        fun byCarNames(carNames: List<String>, numberOfLab: Int = DEFAULT_LAB_COUNT): Setting {
            return Setting(nameToCar(carNames), numberOfLab)
        }

        private fun nameToCar(carNames: List<String>): List<Car> {
            return carNames.map { name -> Car(name = name) }
        }
    }
}
