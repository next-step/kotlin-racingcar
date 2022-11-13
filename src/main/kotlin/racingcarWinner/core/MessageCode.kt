package racingcarWinner.core

enum class MessageCode(val message: String) {
    CarNameMInLengthException("자동차 이름은 ${Car.CAR_NAME_LENGTH_MIN_LIMIT} 자 보다 길어야 합니다."),
    CarNameMaxLengthException("자동차 이름은 ${Car.CAR_NAME_LENGTH_MAX_LIMIT} 자를 초과할 수 없습니다"),
    TryNumberException("시도 횟수의 형식이 맞지 않습니다."),
    CarNamesInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TryNumberQuestion("시도할 횟수는 몇 회 인가요?")
}
