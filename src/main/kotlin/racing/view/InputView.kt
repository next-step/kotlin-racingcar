package racing.view

class InputView {
    private var carName = ""
    private var retryCount = 0

    fun inputCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표 (,)를 기준으로 구분).")
        carName = readln()
        return splitCarName(carName)
    }

    fun inputRetryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = readln().toInt()
        require(validate(count)) {
            "시도할 횟수는 0 이상 이어야 합니다."
        }
        retryCount = count
        return retryCount
    }

    private fun validate(retryCount: Int): Boolean {
        return retryCount > 0
    }

    private fun splitCarName(carName: String): List<String> {
        return carName.split(",")
    }
}
