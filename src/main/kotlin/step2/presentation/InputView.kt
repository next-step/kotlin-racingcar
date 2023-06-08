package step2.presentation

object InputView {

    fun readInput(): String = requireNotNull(value = readln().takeIf { it.isNotBlank() })
}
