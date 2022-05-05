package calculator.view

import java.util.Scanner

class InputView {

    companion object {
        private val scanner = Scanner(System.`in`)

        fun printInputMessage() {
            println("수식을 입력하세요.")
        }

        fun inputExpression(): String {
            return scanner.nextLine()
        }
    }
}