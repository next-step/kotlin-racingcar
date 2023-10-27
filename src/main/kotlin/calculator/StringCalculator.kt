package calculator

class StringCalculator {
    fun calculate(input: String): String {
        val inputList: List<String> = InputValidateParser.parse(input)
        val chunkStringCalculator = ChunkStringCalculator(inputList)

        var result: String = ""
        while (chunkStringCalculator.isContinued()) {
            result = chunkStringCalculator.calculate()
        }

        if (chunkStringCalculator.isValidResult()) {
            return result
        } else {
            throw IllegalArgumentException("(피)연산자 부족으로 계산에 실패했다.")
        }
    }
}

fun main() {
    ConsolePrinter.printMsg("계산할 식을 입력해주세요.")
    val stringInput = ConsoleReader.readInput()
    val stringCalculator = StringCalculator()
    val stringOutput = stringCalculator.calculate(stringInput)
    ConsolePrinter.printMsg("계산 결과는 $stringOutput 입니다.")
}
