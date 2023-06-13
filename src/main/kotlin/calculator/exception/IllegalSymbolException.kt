package calculator.exception

class IllegalSymbolException(symbol: String) : IllegalArgumentException("기호가 올바르지 않습니다. symbol:$symbol")
