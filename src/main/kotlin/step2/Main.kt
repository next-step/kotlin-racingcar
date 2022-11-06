package step2

import step2.calculator.CalculatorImpl
import step2.calculator.CalculatorInput
import step2.calculator.system.SystemImpl
import step2.user.UserCleanedInput
import step2.user.UserOriginalInput

fun main() {

    val calculatorSystem = SystemImpl()
    val calculator = CalculatorImpl(calculatorSystem)

    println("계산하고자 하는 문자열을 입력해 주세요.")
    println("공백으로 문자를 구분합니다.")
    println("중복된 숫자는 이전 값을 덮어씌우며, 중복된 지연 함수는 이전 함수를 무시합니다.")

    val userOriginalInput = UserOriginalInput(readLine())
    val userCleanedInput = UserCleanedInput.from(userOriginalInput.context)
    val calculatorInput = CalculatorInput.from(userCleanedInput.inputList)

    val result = calculator.enter(calculatorInput)

    println("결과 값은 ${result.value} 입니다.")
}
