package racinggame.view.converter

class StringToIntConverter : InputConverter<Int> {
    override fun convert(input: String): Int = input.toInt()
}
