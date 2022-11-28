package racingcar.domain.exception

class CarNameLengthException(message: String = "올바르지 않은 게임 세팅값입니다.") : IllegalArgumentException(message)
