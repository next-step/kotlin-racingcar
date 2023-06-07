package step2.calculator

import java.util.Scanner

class Input {
    companion object {
        private val scanner: Scanner = Scanner(System.`in`)
        fun inputData(): String = scanner.nextLine()
    }
}
