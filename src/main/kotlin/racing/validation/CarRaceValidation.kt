package racing.validation

import racing.exception.CarNameLengthExcessException

class CarRaceValidation {

    fun validateCarName(carNames: List<String>) {
        if (!carNames.none { it.length > 5 }) {
            throw CarNameLengthExcessException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}
