package step3.view

private val READLINE_CANNOT_BE_NULL_EXCEPTION = IllegalArgumentException("readLine은 null일 수 없습니다.")

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회 인가요?")
    return readLine()?.toInt()
        ?: throw READLINE_CANNOT_BE_NULL_EXCEPTION
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    return readLine()?.split(",")
        ?: throw READLINE_CANNOT_BE_NULL_EXCEPTION
}
