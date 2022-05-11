package racinggame.validator

interface InputValidator<T> {
    fun validate(input: T): T
}