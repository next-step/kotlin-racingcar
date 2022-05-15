package racinggame.view.converter

object StringToIntConverter : InputConverter<Int> {
    override fun convert(input: String): Int = input.toInt()
}
