package racinggame.view.parser

class DefaultParser<T> : InputParser<T, T> {
    override fun parse(input: T): T = input
}