package racingcar

const val CAR_NUMBER_QUESTION_MESSAGE = "자동차 대수는 몇 대인가요?"
const val TRY_COUNT_QUESTION_MESSAGE = "시도할 횟수는 몇 회인가요?"

fun readCarNumber(): Int {
    println(CAR_NUMBER_QUESTION_MESSAGE)
    return readln().toInt()
}

fun readTryCount(): Int {
    println(TRY_COUNT_QUESTION_MESSAGE)
    return readln().toInt()
}
