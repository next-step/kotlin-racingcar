package racing.ui

object RacingInputReceiver {

    private const val MAX_NAME_LENGTH = 5
    private const val MIN_MOVE_COUNT = 0

    @Throws(IllegalArgumentException::class)
    fun receive(): UserInput {
        val carNames = receiveCarNames()
        val moveCount = receiveMoveCount()
        return UserInput(carNames, moveCount)
    }

    private fun receiveCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = requireNotNull(readLine())
            .replace(" ", "")
            .split(",")

        require(carNames.none { it.count() > MAX_NAME_LENGTH }) { "이름은 ${MAX_NAME_LENGTH}자 이하로 가능합니다." }

        return carNames
    }

    private fun receiveMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = requireNotNull(readLine()?.toInt())
        require(count >= MIN_MOVE_COUNT) { "이동은 $MIN_MOVE_COUNT 이상을 입력해야 합니다." }
        return count
    }
}
