package racingcar.exception

class InvalidDriverNameException(name: String, limit: Int) : RuntimeException("이름은 ${limit}을 넘을 수 없습니다. `$name`")
