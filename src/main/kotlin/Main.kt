fun main() {

    println(
        "STEP2 문자열 계산기 \n\n" +
            "소수점이하 여덟번째 자리까지 표현하며, 아홉번째 자리에서 반올림 합니다.\n" +
            "숫자와 사칙연산 기호로 이루어진 문자열을 입력해주세요.\n" +
            "예시 : 2 + 3 * 4 / 2" +
            "문자열을 입력하시고 엔터키를 눌러주세요.\n"
    )
    val stringInput = readLine()!!
    val calculator = Calculator()
    val result = when (calculator.checkValidation(stringInput)) {
        InputValidation.SUCCESS -> "정답 :$calculator.calculate(stringInput)"
        InputValidation.BLANK_ERROR -> "숫자와 사칙연산 기호 사이에는 반드시 하나의 공백이 포함되어야 합니다."
        InputValidation.EMPTY_STRING -> "계산식을 입력해주세요."
        InputValidation.CALCULATOR_SYMBOL -> "숫자와 숫자 사이에는 반드시 사칙연산 기호가 입력되어야 합니다."
        InputValidation.INVALID_NUMBER_SYMBOL_ORDER -> "숫자 다음에는 반드시 사칙연산 기호가 입력되어야 합니다."
        InputValidation.ZERO_AFTER_DIVIDE -> "정답 : 무한대"
    }
    println(result)
}
