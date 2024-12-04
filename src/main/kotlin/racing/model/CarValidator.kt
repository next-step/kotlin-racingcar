package racing.model

import racing.exception.InvalidCarNameException
import racing.model.Car.Companion.MAX_NAME_LENGTH

object CarValidator {
    fun validateNameLength(name: String): String {
        if (name.length > MAX_NAME_LENGTH) {
            throw InvalidCarNameException("자동차의 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없습니다.")
        }
        return name
    }
}
