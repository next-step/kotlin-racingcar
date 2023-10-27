package calculator

@JvmInline
value class Number(private val number: String) {

    init {
        require(number.isNumber()) { "숫자가 아닙니다." }
    }

    private fun String.isNumber(): Boolean {
        return this.matches(Regex("[0-9]+"))
    }
    fun getNumber() = number.toInt()
}
