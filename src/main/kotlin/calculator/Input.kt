package calculator

@JvmInline
value class Input(private val value: String?) {
    init {
        require(!value.isNullOrBlank()) {
            "표현식은 공백일 수 없습니다."
        }
    }

    fun split(delimiter: String): List<String> {
        return value!!.split(delimiter)
    }
}
