package stringcalculator.ui

private const val INPUT_MESSAGE = "수식을 입력해주세요"
private const val DELIMITER = " "

object InputView {

    fun inputFormula(): List<String> {
        println(INPUT_MESSAGE)
        return readln().split(DELIMITER)
    }
}
