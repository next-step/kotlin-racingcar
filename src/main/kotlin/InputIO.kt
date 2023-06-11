import java.lang.NumberFormatException

class InputIO {
    fun inputNumber(numberType: InputType): Int {
        inputView(numberType)

        val inputValue = checkNumber(readlnOrNull())
        if (inputValue != null)
            return inputValue

        return inputNumber(numberType)
    }

    private fun inputView(numberType: InputType) {
        numberType.display()
    }

    private fun checkNumber(inputString: String?): Int? {
        return try {
            Integer.parseInt(inputString)
        } catch (e: NumberFormatException) {
            println("양수만 입력해 주세요")
            null
        }
    }
}
