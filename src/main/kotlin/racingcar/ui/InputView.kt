package racingcar.ui

object InputView {
    fun run(): GameInput {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()
        requireNotNull(carCount) { "자동차 이름을 입력해주세요." }

        val carNames = readLine()!!
        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()?.toIntOrNull()
        requireNotNull(round) { "시도할 횟수는 숫자로 입력해주세요." }

        println()

        return GameInput(carNames, round)
    }
}
