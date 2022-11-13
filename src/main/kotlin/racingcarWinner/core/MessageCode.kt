package racingcarWinner.core

enum class MessageCode(val message: String) {
    CarNameMInLengthException("자동차 이름은 ${Car.CAR_NAME_LENGTH_MIN_LIMIT} 자 보다 길어야 합니다."),
    CarNameMaxLengthException("자동차 이름은 ${Car.CAR_NAME_LENGTH_MAX_LIMIT} 자를 초과할 수 없습니다"),
}
