package racingcar.exception

class CannotFindWinnerException(message: String = "우승자를 찾을 수 없습니다.") : RuntimeException(message)
