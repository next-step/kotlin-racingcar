package racing

class RacingInputReceiver {

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

        require(carNames.none { it.count() > 5 }) { "이름은 5자 이하로 가능합니다." }

        return carNames
    }

    private fun receiveMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = requireNotNull(readLine()?.toInt())
        require(count >= 0) { "이동은 0 이상을 입력해야 합니다."}
        return count
    }
}
