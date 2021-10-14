package stringArithmeticCalculator

class Calculator(private val input : String) {
    init {
        if(input.isBlank()) throw IllegalArgumentException("공백 문자는 올 수 없습니다.")
    }
}