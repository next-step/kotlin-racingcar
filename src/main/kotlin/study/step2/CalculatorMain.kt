package study.step2

fun main() {
    print("계산식을 입력해주세요 : ")
    val value: String = readLine()!!

    Expression.valid(value)
    val calculator = Calculator()
    val result = calculator.calc(Expression.parse(value))

    print("계산식의 결과는  $result 입니다")
}
