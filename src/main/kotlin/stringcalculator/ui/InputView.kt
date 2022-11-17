package stringcalculator.ui

import java.util.Scanner

val SCANNER: Scanner = Scanner(System.`in`)

const val INPUT_MESSAGE: String = "수식을 입력해주세요"

class InputView {

    fun inputFormula(): List<String> {
        println(INPUT_MESSAGE)
        return SCANNER.nextLine().split(" ")
    }
}
