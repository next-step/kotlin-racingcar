package racing.domain.validation

import racing.domain.exception.CarNameLengthExcessException

class CarRaceValidation {

    fun validateCarName(carNames: List<String>) {
        if (carNames.none { CAR_NAME_RANGE.contains(it.trim().length) }) {
            throw CarNameLengthExcessException("자동차 이름은 ${CAR_NAME_RANGE.first}자 이상이어야 하고, ${CAR_NAME_RANGE.last}자를 초과할 수 없습니다.")
        }
    }

    companion object {
        private val CAR_NAME_RANGE = IntRange(1, 5)
    }
}
