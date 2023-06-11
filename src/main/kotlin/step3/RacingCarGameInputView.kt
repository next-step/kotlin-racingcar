package step3

class RacingCarGameInputView {

    val totalCarCount: Long by lazy {
        println("자동차 대수는 몇 대인가요?")
        readln().toLong()
    }

    val totalRound: Long by lazy {
        println("시도할 횟수는 몇 대인가요?")
        readln().toLong()
    }
}
