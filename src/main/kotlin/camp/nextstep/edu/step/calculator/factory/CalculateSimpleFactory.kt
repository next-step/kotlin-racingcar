package camp.nextstep.edu.step.calculator.factory

import camp.nextstep.edu.step.calculator.domain.MedianResult

/**
 * @description : 연산을 처리하는 Factory object
 */
//TODO : BiFunction을 사용해 Enum Class에서 연산을 처리해도 좋지 않을까?
object CalculateSimpleFactory {

    fun calculateByStringExpressionNumbers(numbers: List<String>): MedianResult {
        var midResult = toLong(numbers[0])

        for (i in 1 until numbers.size step 2) {
            val operationSymbols = numbers[i]
            val rngNumber = toLong(numbers[i + 1])

            midResult = when (operationSymbols) {
                "+" -> add(midResult, rngNumber)
                "-" -> subtract(midResult, rngNumber)
                "*" -> multiply(midResult, rngNumber)
                "/" -> divide(midResult, rngNumber)
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
            }
        }
        return MedianResult.of(medianResult = midResult)
    }

    private fun toLong(number: String): Long = number.toLong()

    private fun add(firstNumber: Long, lastNumber: Long): Long = firstNumber + lastNumber

    private fun subtract(firstNumber: Long, lastNumber: Long): Long = firstNumber - lastNumber

    private fun multiply(firstNumber: Long, lastNumber: Long): Long = firstNumber * lastNumber

    private fun divide(firstNumber: Long, lastNumber: Long): Long {
        require(lastNumber != 0L) { "0으로 나눌 수 없습니다." }
        return firstNumber / lastNumber
    }
}
