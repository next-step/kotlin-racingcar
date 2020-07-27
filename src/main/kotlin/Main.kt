fun main() {
    // 문자열 계산기 실행코
    // println(
    //     "STEP2 문자열 계산기 \n\n" +
    //         "소수점이하 여덟번째 자리까지 표현하며, 아홉번째 자리에서 반올림 합니다.\n" +
    //         "숫자와 사칙연산 기호로 이루어진 문자열을 입력해주세요.\n" +
    //         "예시 : 2 + 3 * 4 / 2" +
    //         "문자열을 입력하시고 엔터키를 눌러주세요.\n"
    // )
    // try {
    //     val stringInput = readLine()!!
    //     println(Calculator.calculate(stringInput))
    // } catch (e: Exception) {
    //     println(e.message)
    // }

    println(
        "STEP3 자동차 경주 \n\n" +
            "자동차 대수는 몇 대인가요? "
    )
    val numberOfCars = readLine()!!
    println(
        "시도할 횟수는 몇 회인가요?"
    )
    val numberOfTrial = readLine()!!
    try {
        CarRacing.execute(numberOfCars, numberOfTrial)
    } catch (e: Exception) {
        println(e.message)
    }
}
