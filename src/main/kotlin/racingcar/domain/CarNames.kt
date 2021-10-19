package racingcar.domain

import java.util.stream.Collectors.toList

class CarNames(private val carNames: List<CarName>) {
    fun getCarNames(): List<CarName> {
        return carNames.toList()
    }

    fun size(): Int {
        return carNames.size
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
        private const val ENTERED_WRONG_CAR_NAMES = "자동차 이름들을 올바르게 입력하세요."

        fun from(input: String?): CarNames {
            require(input != null && input.isNotBlank()) { ENTERED_WRONG_CAR_NAMES }
            return CarNames(collectCarNames(input))
        }

        private fun collectCarNames(input: String) = input.split(CAR_NAME_DELIMITER)
            .stream()
            .map { CarName.from(it.trim()) }
            .collect(toList())
    }
}
