package racing.view

class InputView {
    var carCount = 0
    var retryCount = 0

    fun validate(target: Int): Boolean {
        return target > 0
    }

    fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val count = readln().toInt()
        require(validate(count)) {
            "자동차 대수는 0 이상 이어야 합니다."
        }
        this.carCount = count
        return this.carCount
    }

    fun inputRetryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = readln().toInt()
        require(validate(count)) {
            "시도할 횟수는 0 이상 이어야 합니다."
        }
        this.retryCount = count
        return this.retryCount
    }
}
