package calculator

import calculator.Calculator
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * 문자열 계산기 테스트
 * */

class CalculatorTest : FunSpec({
    test("null 입력시 오류가 발생한다.") {
        Calculator.calculate(null)
    }

    test("빈 문자열만 입력시 오류가 발생한다.") {
        Calculator.calculate("")
    }

    test("공백 문자만 입력시 오류가 발생한다.") {
        Calculator.calculate(" ")
    }

    test("탭 문자 입력시 오류가 발생한다.") {
        Calculator.calculate("\t")
    }

    test("줄바꿈 문자 입력시 오류가 발생한다.") {
        Calculator.calculate("\n")
    }

    test("숫자 사이에 공백문자가 없을 경우 오류가 발생한다.") {
        Calculator.calculate("2 +3")
    }

    test("공백 문자가 두번 이상 겹쳐 입력시 오류가 발생한다.") {
        Calculator.calculate("2 +  3")
    }

    test("숫자 사이에 공백 문자를 같이 입력시 오류가 발생한다.") {
        Calculator.calculate("2 3 + 3")
    }

    test("부호 먼저 입력시 오류가 발생한다.") {
        Calculator.calculate("+ 3 + 3")
    }

    test("계산식 마지막에 부호를 입력시 오류가 발생한다.") {
        Calculator.calculate("2 3 + 3")
    }

    test("부호를 연속해서 입력시 오류가 발생한다.") {
        Calculator.calculate("2 + + 3")
    }

    test("잘못된 기호를 입력시 오류가 발생한다.") {
        Calculator.calculate("2 % 3 - 9")
    }

    test("\"2 + 3 * 4 / 2\" 입력시 결과값 10을 반환한다.") {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    test("\"10000 + 20000 / 3 * 10\" 입력시 결과값 100000을 반환한다.") {
        Calculator.calculate("10000 + 20000 / 3 * 10") shouldBe 100000
    }

    test("\"2 * 3 / 2 / 3 + 3 + 4\" 입력시 결과값 8을 반환한다.") {
        Calculator.calculate("2 * 3 / 2 / 3 + 3 + 4") shouldBe 8
    }

})