package calculator

@JvmInline
value class Number(private val number: String) {

    companion object {
        private val REGEX = Regex("^(0|-?[1-9]\\d*)$")
    }
    init {
        require(number.isNumber()) { "숫자가 아닙니다." }
    }

    private fun String.isNumber(): Boolean {
        return this.matches(REGEX)
    }
    fun getNumber() = number.toInt()
}
