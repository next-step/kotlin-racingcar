package racingcar

class RacingCarGameInputView {

    val totalCarCount: Long by lazy {
        println("자동차 대수는 몇 대인가요?")
        readln().toLong()
    }

    val carNames: List<String> by lazy {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNames = readlnOrNull()
        inputCarNames?.split(delimiters = arrayOf(INPUT_DELIMITERS)) ?: emptyList()
    }

    val totalRound: Long by lazy {
        println("시도할 횟수는 몇 회인가요?")
        readln().toLong()
    }

    companion object {
        const val INPUT_DELIMITERS = ","
    }
}
