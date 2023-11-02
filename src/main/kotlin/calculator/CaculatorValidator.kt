package calculator

class CaculatorValidator {
    companion object {
        private val numberPattern = Regex("\\d+")

        fun validate(formulas: MutableList<String>) {
            if (formulas.isEmpty()) {
                throw IllegalArgumentException("연산식은 빈값일 수 없습니다.")
            }
            if (formulas.size == 1) {
                throw IllegalArgumentException("연산식은 여러자로 구성되어야합니다.")
            }
            if (formulas.size % 2 == 0) {
                throw IllegalArgumentException("연산식을 잘못 입력하셨습니다.")
            }
            if (formulas.any {
                try {
                    Operator.OperatorSymbol.of(it)
                } catch (e: IllegalArgumentException) {
                    if (!numberPattern.matches(it)) {
                        return@any true
                    }
                }

                return@any false
            }
            ) {
                throw IllegalArgumentException("연산식을 잘못 입력하셨습니다.")
            }

            for (i in 0 until formulas.size - 1) {
                if (numberPattern.matches(formulas[i]) && numberPattern.matches(formulas[i + 1])) {
                    throw IllegalArgumentException("연산식을 잘못 입력하셨습니다.")
                }

                try {
                    if (Operator.OperatorSymbol.of(formulas[i]) != null && Operator.OperatorSymbol.of(formulas[i + 1]) != null) {
                        throw IllegalArgumentException("연산식을 잘못 입력하셨습니다.")
                    }
                } catch (e: IllegalArgumentException) {
                    continue
                }
            }
        }
    }
}
