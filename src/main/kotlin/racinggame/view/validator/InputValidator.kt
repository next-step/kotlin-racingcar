package racinggame.view.validator

interface InputValidator<T> {
    fun validate(input: T): T
}