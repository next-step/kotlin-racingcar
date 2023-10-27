package calculator

fun main() {
    // 계산기 초기화
    val calculator = Calculator().apply {
        input("2 + 3 * 4 / 2")
    }

    // 계산 결과 값 출력
    print(calculator.calculate())
}

class Calculator {

    // 계산할 값
    private var inputStr: String? = null

    // 계산할 값을 입력 받음
    fun input(inputStr: String?) {
        this.inputStr = inputStr
    }

    // 계산 시작
    fun calculate(): Int {
        // 에러 체크
        checkError(inputStr)

        inputStr?.let {

            // 숫자 리스트
            val numberList: MutableList<Int> = mutableListOf()
            // 부호 리스트
            val signList: MutableList<String> = mutableListOf()

            // 숫자 기호 분리
            val splitFormulaList = it.split(" ")
            splitFormulaList.forEach { value ->
                if (value.toIntOrNull() != null) {
                    numberList.add(value.toInt())
                } else {
                    signList.add(value)
                }
            }

            // 결과 값
            var result = 0

            // 계산하기
            numberList.forEachIndexed { index, number ->
                if (index == 0) {
                    result = number
                } else {
                    when(signList[index - 1]) {
                        "+" -> result += number
                        "-" -> result -= number
                        "*" -> result *= number
                        "/" -> result /= number
                    }
                }
            }
            return result
        }
        return 0
    }

    // 에러 체크
    private fun checkError(inputStr: String?) {
        // 입력값이 null인 경우
        inputStr ?: throw IllegalArgumentException()

        // 입력값이 빈 공백 문자이거나 사칙연산 기호가 아닌 경우
        if (inputStr.isBlank() || inputStr.split(" ").any { it.toIntOrNull() == null && it != "+" && it != "-" && it != "*" && it != "/" }) {
            throw IllegalArgumentException()
        }
    }
}