package calculator

object StringExtension {
    fun String.checkNullOrEmpty(): Boolean {
        val input = this.replace(Constant.SPACE, Constant.EMPTY)
        return input.isEmpty()
    }
}
