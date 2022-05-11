package calculator

import java.util.LinkedList
import java.util.Queue

class Lexer private constructor(
    private val tokens: Queue<Token>,
) {
    companion object {
        private const val DELIMITER = ' '

        fun from(input: String): Lexer {
            require(input.isNotBlank())

            return input
                .split(DELIMITER)
                .filter { it.isNotBlank() }
                .map { str ->
                    when (str) {
                        "+" -> Token.Plus
                        "-" -> Token.Minus
                        "*" -> Token.Asterisk
                        "/" -> Token.Slash
                        else -> str.toDoubleOrNull()
                            ?.let { Token.Number(it) }
                            ?: throw IllegalArgumentException("유효하지 않은 문자열입니다: $str")
                    }
                }.let { Lexer(LinkedList(it)) }
        }
    }

    fun next(): Token = tokens.poll() ?: Token.EOF

    fun isEOF(): Boolean = tokens.isEmpty()
}
