package racing.ui

object InputView {
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(",")

        require(carNames.isNotEmpty()) { "자동차 이름의 개수가 잘못되었습니다." }

        return carNames
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()

        require(tryCount >= 0) { "시도 횟수는 0보다 작을 수 없습니다." }

        return tryCount
    }
}
