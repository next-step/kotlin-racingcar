package racinggame.view.converter

interface InputConverter<R> {
    fun convert(input: String): R
}