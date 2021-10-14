package calculator

object StringExtension {
    fun String.checkNullOrEmpty(): Boolean {
        val input = this.replace(InputParser.SPACE, InputParser.EMPTY)
        return input.isEmpty()
    }
}
