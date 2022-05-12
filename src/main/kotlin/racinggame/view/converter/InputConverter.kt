package racinggame.view.converter

interface InputConverter<T> {
    fun convert(input: String): T
}
