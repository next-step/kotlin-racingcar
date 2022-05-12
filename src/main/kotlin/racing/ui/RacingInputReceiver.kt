package racing.ui

object RacingInputReceiver {

    @Throws(IllegalArgumentException::class)
    fun receive(): UserInput {
        val carNames = receiveCarNames()
        val moveCount = receiveMoveCount()

        return UserInput(carNames, moveCount)
    }

    private fun receiveCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return requireNotNull(readLine())
            .replace(" ", "")
            .split(",")
    }

    private fun receiveMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return requireNotNull(readLine()?.toInt())
    }
}
