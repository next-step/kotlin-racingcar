package racingcar.io

object InputView {

    fun requestPositiveNumber(): Int {
        val input: String = this.requestString()
        val number = input.toIntOrNull()

        require(number != null) { "숫자를 입력 해주세요." }
        require(number > 0) { "양수를 입력 해주세요." }

        return number
    }

    fun requestString(delimiters: String, maxElementSize: Int = 5): List<String> {
        val input: String = this.requestString()
        val split = input.split(delimiters)

        require(split.all { it.length <= maxElementSize })

        return split
    }

    private fun requestString(): String {
        val input: String? = readLine()
        require(!input.isNullOrBlank()) { "빈값을 입력 할 수 없습니다." }

        return input
    }
}
