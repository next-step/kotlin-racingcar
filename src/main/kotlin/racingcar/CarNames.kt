package racingcar

class CarNames(val values: List<CarName>) {

    fun size(): Int {
        return this.values.size
    }

    fun get(index: Int): CarName {
        return this.values[index]
    }

    companion object {
        fun of(carNames: String): CarNames {
            validateCarNames(carNames)
            val splitCarNames: List<String> = carNames.split(NAMES_DELIMITER)
            return CarNames(values = List(splitCarNames.size) { CarName.of(splitCarNames[it].trim()) })
        }

        private fun validateCarNames(carNames: String) {
            require(carNames.isNotBlank()) { "차 이름들의 값은 빈 값이거나 공백일 수 없습니다. carNames: $carNames" }
        }

        private const val NAMES_DELIMITER = ","
    }
}
