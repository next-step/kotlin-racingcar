package calculator.io

import calculator.domain.InputValidator

/**
 * 사용자 입력 받기
 */
class Console(private val inputValidator: InputValidator) {

    constructor() : this(InputValidator())

    fun getInput(): String {
        val readLine = readLine()
        return inputValidator.validate(readLine)
    }
}
