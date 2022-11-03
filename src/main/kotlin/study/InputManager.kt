package study

import java.util.Scanner

class InputManager {

    companion object {
        private val scanner: Scanner = Scanner(System.`in`)
        fun nextLine(): String {
            return validateInput(scanner.nextLine())
        }

        private fun validateInput(input: String?): String {
            if (input.isNullOrBlank()) {
                throw IllegalArgumentException("옳지 않은 값입니다.")
            }
            return input
        }
    }
}
