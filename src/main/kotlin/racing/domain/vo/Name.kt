package racing.domain.vo

import racing.exception.CarNameException

@JvmInline
value class Name(val value: String) {
    init {
        if (value.trim().length !in NAME_LENGTH_RANGE) throw CarNameException(INVALID_CAR_NAME_LENGTH)
    }

    companion object {
        private val NAME_LENGTH_RANGE = (1..5)
        private const val INVALID_CAR_NAME_LENGTH = "자동차의 이름은 1~5글자 사이입니다."
    }
}
