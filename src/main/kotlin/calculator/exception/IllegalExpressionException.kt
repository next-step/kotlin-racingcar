package calculator.exception

class IllegalExpressionException(message: String = "올바르지 않은 표현식입니다.") : IllegalArgumentException(message)
