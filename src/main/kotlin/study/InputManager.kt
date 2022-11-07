package study

object InputManager {

    private const val INPUT_DATA_SPLIT_DELIMITER = " "

    fun inputData(): String {
        return validateInput(readLine())
    }

    fun splitInputData(input: String): List<String> {
        return input.split(INPUT_DATA_SPLIT_DELIMITER)
    }

    fun groupByNumberAndOperator(splitStrings: List<String>): List<List<String>> {
        return splitStrings.withIndex()
            .groupBy { it.index % 2 }
            .map { it.value.map { valueIt -> valueIt.value } }
    }

    private fun validateInput(input: String?): String {
        require(!input.isNullOrBlank()) { "빈 값을 입력할 수 없습니다." }
        return input
    }
}
