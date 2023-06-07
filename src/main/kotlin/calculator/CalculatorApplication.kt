package calculator

import calculator.io.Console
import calculator.domain.Calculator
import calculator.utils.CalculatorParser

fun main() {
    Main().start()
}

/**
 * 실행에 필요한 의존성 주입, 전체 프로그램 실행 역할
 * 유연한 테스트를 위해 의존성 주입을 위한 생성자와 실행을 위한 생성자로 구분지어서 설계하였습니다.
 */
class Main(
    private val calculator: Calculator,
    private val console: Console,
) {

    constructor() : this(
        Calculator(),
        Console(),
    )

    /**
     * 1. 문자열 입력을 받는다
     * 1-1. 입력받은 문자열 유효성 검사를 진행한다.
     * 2. 입력받은 문자열에서 연산자와 피연산자를 추출한다.
     * 3. 추출한 연산자와 피연산자를 순서대로 계산한다.
     * 3-1. 연산자 enum을 통해 연산자를 관리한다.
     * 4. 계산한 값을 리턴한다.
     */
    fun start() {
        val input = console.getInput()
        val extractedList = CalculatorParser.extract(input)
        val result = calculator.calculate(extractedList)
        println(result)
    }
}
