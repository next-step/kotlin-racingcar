class StringCalculator(
    private var stringCalculatorScanner: StringCalculatorScanner
) {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty())
            throw IllegalArgumentException("문자열을 확인해 주세요")

        return stringCalculatorScanner.scan(input.split(" "))
    }
}
