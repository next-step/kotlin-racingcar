package view.calculator

import java.util.Scanner

class InputView {
    companion object {
        private val SCANNER = Scanner(System.`in`)

        fun inputExpression(): String {
            print("수식을 입력해주세요 : ")
            return SCANNER.nextLine()
        }
    }
}
