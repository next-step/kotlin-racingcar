package racinggame.util

interface InputValidator<T> {
    fun validate(input: T): T
}