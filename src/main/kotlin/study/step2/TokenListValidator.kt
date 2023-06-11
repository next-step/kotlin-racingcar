package study.step2

import java.lang.IllegalArgumentException

class TokenListValidator {
    fun validate(tokens: List<String>) {
        validateFormat(tokens)
        validateEveryToken(tokens)
    }

    private fun validateEveryToken(tokens: List<String>) {
        tokens.forEachIndexed { idx, curr ->
            val isOperator = isOperator(curr)
            val isLongType = isLongTypeToken(curr)

            if (!isOperator && !isLongType) {
                throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
            }
            if (isOperator) {
                isOperatorTokenPositionValid(idx)
            }
        }
    }

    private fun validateFormat(tokens: List<String>) {
        if (!isLongTypeToken(tokens.first()) || !isLongTypeToken(tokens.last())) {
            throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
        }
    }

    private fun isOperatorTokenPositionValid(position: Int) {
        if (position % 2 == 0) {
            throw IllegalArgumentException("사칙연산식의 포맷이 올바르지 않습니다")
        }
    }

    private fun isOperator(token: String): Boolean {
        return Operator.ofCode(token) != null
    }

    private fun isLongTypeToken(token: String): Boolean {
        return token.toLongOrNull() != null
    }
}
