package step2.parser

import step2.calculator.Node

interface NodeParser {
    fun parse(text: String): List<Node>

    sealed class Error(message: String) : Exception(message) {
        object InvalidCharacter : Error("Invalid character has found in text.")
    }
}
