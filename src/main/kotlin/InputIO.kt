import java.lang.NumberFormatException

class InputIO {
    private lateinit var inputView: InputView

    fun inputNumber(numberType: InputType): Int {
        inputView(numberType)

        val inputValue = checkNumber(readlnOrNull())
        if (inputValue != null)
            return inputValue

        return inputNumber(numberType)
    }

    private fun inputView(numberType: InputType) {
        inputView =
            when (numberType) {
                InputType.CAR_COUNT -> CarCountMessage()
                InputType.GAME_COUNT -> GameCountMessage()
            }
        inputView.displayMessage()
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
