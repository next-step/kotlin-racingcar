package calculator

class StringCalculator : Calculator {

    fun calculate(input: String?): Int {
        // 1. 입력값이 null 이거나 빈 문자열인지 확인
        isNullOrBlank(input)

        // 2. 문자열의 앞뒤 공백과 중복 공백 제거
        var expr = ""
        if (input != null) {
            expr = removeSpace(input)
        }

        // 3. 계산식을 숫자와 연산기호로 분리
        val (operand, operator) = divideExpr(expr)

        // 4. 대기열에서 숫자, 연산기호를 꺼내어 계산
        var result = operand[0]
        for (i in 0..operand.size - 2) {
            when (operator[i]) {
                '+' -> result = plus(result, operand[i + 1])
                '-' -> result = minus(result, operand[i + 1])
                '*' -> result = times(result, operand[i + 1])
                '/' -> result = div(result, operand[i + 1])
            }
        }

        return result
    }

    fun divideExpr(expr: String): Pair<List<Int>, List<Char>> {
        val tokens = expr.split(" ")

        val operand = mutableListOf<Int>()
        val operator = mutableListOf<Char>()
        var prev = 'S' // 이전값이 숫자였으면 'N', 기호였으면 'S'

        for (token in tokens) {
            // 1. 사칙연산 기호가 아닌 기호가 포함되었는지 확인
            if (isInt(token)) {
                // 2. 기호 간의 순서를 지켰는지 확인 (숫자 -> 연산기호 -> 숫자 -> ...)
                if (prev == 'N') throw IllegalArgumentException()
                else prev = 'N'
                operand.add(token.toInt())
            } else if (isOperator(token)) {
                if (prev == 'S') throw IllegalArgumentException()
                else prev = 'S'
                operator.add(token.first())
            } else {
                throw IllegalArgumentException()
            }
        }

        // 3. 입력값의 숫자와 연산기호의 쌍이 맞는지 확인 (숫자 개수 - 1 = 연산기호 개수)
        if ((operand.size - 1) != operator.size) {
            throw IllegalArgumentException()
        }

        return Pair(operand.toList(), operator.toList())
    }

    fun isNullOrBlank(s: String?): Boolean {
        if (s.isNullOrBlank()) throw IllegalArgumentException()
        return true
    }

    fun removeSpace(s: String): String {
        return s.trim().replace(Regex("\\s+"), " ")
    }

    private fun isInt(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun isOperator(s: String): Boolean {
        return s.matches(Regex("[+\\-*/]"))
    }

    override fun plus(a: Int, b: Int): Int {
        return a + b
    }

    override fun minus(a: Int, b: Int): Int {
        return a - b
    }

    override fun times(a: Int, b: Int): Int {
        return a * b
    }

    override fun div(a: Int, b: Int): Int {
        return a / b
    }
}
