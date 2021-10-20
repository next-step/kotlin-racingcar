package racingcar.model

import racingcar.exception.Exception

@JvmInline
value class CarName(private val name: String) {
    init {
        require(name.isNotBlank()) { Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR }
        require(name.length <= MAX_NAME_OF_CAR) { Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR }
    }

    val carName: String
        get() = name

    companion object {
        private const val MAX_NAME_OF_CAR = 5
    }
}
