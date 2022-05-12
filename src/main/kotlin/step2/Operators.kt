package step2

class Operators {
    companion object {
        val list = listOf<String>("+", "-", "*", "/")
        val plus = { a: Double, b: Double -> a + b }
        val subtract = { a: Double, b: Double -> a - b }
        val multiply = { a: Double, b: Double -> a * b }
        const val division0ErrorMessage = "0 으로 나눌 수 없습니다."
        val division = { a: Double, b: Double ->
            if (b == 0.0) {
                throw IllegalArgumentException(division0ErrorMessage)
            }
            a / b
        }
    }
}
