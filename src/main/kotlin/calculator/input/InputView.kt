package calculator.input

object InputView {

    private const val INPUT_MESSAGE = "식을 입력해주세요."
    private const val INPUT_DELIMITER = " "

    fun read(): List<String> {
        println(INPUT_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        return split(userInput!!.trim())
    }

    private fun validateIsNullOrBlank(userInput: String?) {
        require(!userInput.isNullOrBlank()) {
            "입력값이 존재하지 않습니다."
        }
    }

    private fun split(input: String): List<String> {
        return input.split(INPUT_DELIMITER)
    }
}
