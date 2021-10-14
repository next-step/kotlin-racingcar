package calculator

class OperatorAlreadyExistException(operator: Operator) : Exception(
    "${operator.symbol.symbol} is already exists"
)

class InputNullOrEmptyException : Exception(
    "input must not be null or empty"
)

class OperandNotFoundException : Exception(
    "operand not found"
)

class NotArithmeticOperatorException(symbol: String) : Exception(
    "\"$symbol\" is not arithmetic operator"
)

class StringToIntCastException(value: String) : Exception(
    "can't convert from \"$value\" to Int"
)
