package racingcar.ui

object InputView {
    fun run(): GameInput {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readLine()
        requireNotNull(carNames) { "자동차 이름을 입력해주세요." }

        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()?.toIntOrNull()
        requireNotNull(round) { "시도할 횟수는 숫자로 입력해주세요." }

        println()

        return GameInput(carNames, round)
    }
}
