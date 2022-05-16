package step2

const val division0ErrorMessage = "0 으로 나눌 수 없습니다."

enum class Operator(var operate: (Double, Double) -> Double) {
    PLUS({ a: Double, b: Double -> a + b }),
    SUBTRACT({ a: Double, b: Double -> a - b }),
    MULTIPLY({ a: Double, b: Double -> a * b }),
    DIVISION({ a: Double, b: Double ->
        if (b == 0.0) {
            throw IllegalArgumentException(division0ErrorMessage)
        }
        a / b
    }),
}
