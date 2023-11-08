package racingcar

private const val TRY_COUNT_QUESTION_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val CAR_NAME_QUESTION_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val CAR_NAME_DELIMITER = ","

fun readCarNames(): List<String> {
    println(CAR_NAME_QUESTION_MESSAGE)
    return readln().split(CAR_NAME_DELIMITER)
}

fun readTryCount(): Int {
    println(TRY_COUNT_QUESTION_MESSAGE)
    return readln().toInt()
}
