package step3

class RacingCarGameInputView {

    val totalCarCount: Long by lazy {
        println("자동차 대수는 몇 대인가요?")
        val inputTotalCarCount = readln().toLong()

        require(inputTotalCarCount >= 1) { "자동차 대수는 1 이상이어야 합니다." }
        inputTotalCarCount
    }

    val totalRound: Long by lazy {
        println("시도할 횟수는 몇 대인가요?")
        val inputTotalRound = readln().toLong()

        require(inputTotalRound >= 1) { "시도할 횟수는 1 이상이어야 합니다." }
        inputTotalRound
    }
}
