import java.lang.NumberFormatException

class InputIO {
    fun inputNumber(numberType: InputType): Int {
        inputView(numberType)

        return checkNumber(readlnOrNull()) ?: return inputNumber(numberType)
    }

    private fun inputView(numberType: InputType) {
        println(numberType.message)
    }

    fun checkNumber(inputString: String?): Int? {
        try {
            val value = Integer.parseInt(inputString)

            if (value < 0) {
                println("양수만 입력해 주세요")
                return null
            }

            return value
        } catch (e: NumberFormatException) {
            println("숫자를 입력해 주세요")
            return null
        }
    }
}
