package racinggame.view.parser

class DefaultParser<T> : InputParser<T> {
    override fun parse(input: String): T = input as T
}