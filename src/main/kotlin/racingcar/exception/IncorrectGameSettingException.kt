package racingcar.exception

class IncorrectGameSettingException(message: String = "우승자를 찾을 수 없습니다.") : IllegalArgumentException(message)
