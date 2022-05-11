package racinggame.view.converter

class DefaultConverter<T> : InputConverter<T> {
    override fun convert(input: String): T = input as T
}