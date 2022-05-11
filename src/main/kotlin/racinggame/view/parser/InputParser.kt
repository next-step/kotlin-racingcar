package racinggame.view.parser

interface InputParser<R> {
    fun parse(input: String): R
}