package step2.parser

import step2.calculator.Node

/**
 * 문자열을 계산하기 위한 Node로 변환하는 인터페이스
 */
interface NodeParser {
    fun parse(text: String): List<Node>

    sealed class Error(message: String) : Exception(message) {
        class InvalidCharacter(char: String) : Error("Invalid character $char has found in text.")
    }
}
