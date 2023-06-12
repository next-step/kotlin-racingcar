package calculator.presentation

object InputView {

    fun readInput(): String = requireNotNull(value = readln().takeIf { it.isNotBlank() })
}
