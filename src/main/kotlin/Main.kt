import java.lang.Exception

fun main() {
    println(
        "STEP2 문자열 계산기 \n\n" +
            "소수점이하 여덟번째 자리까지 표현하며, 아홉번째 자리에서 반올림 합니다.\n" +
            "숫자와 사칙연산 기호로 이루어진 문자열을 입력해주세요.\n" +
            "예시 : 2 + 3 * 4 / 2" +
            "문자열을 입력하시고 엔터키를 눌러주세요.\n"
    )
    try {
        val stringInput = readLine()!!
        println(Calculator.calculate(stringInput))
    } catch (e: Exception) {
        println(e.message)
    }
}
