package calculator

class NotSupportedTypeException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, t: Throwable) : super(message, t)
    constructor(t: Throwable) : super(t)
}
