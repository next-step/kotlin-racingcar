package racinggame.view.parser

interface InputParser<T, R> {
    fun parse(input: T): R
}