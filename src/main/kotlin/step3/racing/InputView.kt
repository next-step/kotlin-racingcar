package step3.racing

object InputView {
    fun getInt(input: String?): Int {
        require(!input.isNullOrBlank()) { "입력 값이 없습니다." }
        return input.toIntOrThrow()
    }

    fun getStringArray(input: String?, maxLength: Int): List<String> {
        require(!input.isNullOrBlank()) { "입력 값이 없습니다." }
        val result = input.split(",").onEach {
            if (it.length >= maxLength) throw IllegalArgumentException("길이는 $maxLength 를 넘을 수 없습니다.")
        }
        return result
    }

    private fun String.toIntOrThrow(): Int =
        toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았습니다.")
}
