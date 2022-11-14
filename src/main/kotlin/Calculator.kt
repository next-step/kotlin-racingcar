class Calculator {
    fun main(string: String?): Double {
        if (string.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 없습니다.")
        } else {
            var total: Double = 0.0
            var now: Double = 0.0
            var indicator: String = ""
            string.split(" ").forEachIndexed { index, it ->
                if (index == 0) {
                    total = it.toDouble()
                } else if (index == 1) {
                    indicator = it
                } else if (index % 2 == 0 && it.toDoubleOrNull() != null) {
                    now = it.toDouble()
                    total = calculator(indicator, total, now)
                } else {
                    indicator = it
                }
            }
            return total
        }
    }

    private fun calculator(indicator: String, first: Double, last: Double): Double {
        return when (indicator) {
            "+" -> plus(first, last)
            "-" -> minus(first, last)
            "*" -> multiple(first, last)
            "/" -> divide(first, last)
            else -> {
                throw IllegalArgumentException("연산자가 틀렸습니다.")
            }
        }
    }

    fun plus(first: Double, last: Double): Double {
        return first + last
    }

    fun minus(first: Double, last: Double): Double {
        return first - last
    }

    fun multiple(first: Double, last: Double): Double {
        return first * last
    }

    fun divide(first: Double, last: Double): Double {
        return first / last
    }
}
