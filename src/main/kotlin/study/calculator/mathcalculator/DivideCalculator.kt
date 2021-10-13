package study.calculator.mathcalculator

class DivideCalculator : Calculator {
    override fun calculate(x: Int, y: Int): Int {
        if (y == 0) {
            throw ArithmeticException("0으로 나눌수 없습니다")
        }
        return x / y
    }
}
