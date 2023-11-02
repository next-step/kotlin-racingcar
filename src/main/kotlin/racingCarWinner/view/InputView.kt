package racingCarWinner.view

import racingCarWinner.domain.UserInput

object InputView {
    fun gatherUserInput(): UserInput {
        ConsolePrinter.printMsg("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = ConsoleReader.readInput()

        ConsolePrinter.printMsg("시도할 횟수는 몇 회인가요?")
        val numOfAttempts = ConsoleReader.readInput()

        return UserInput.from(carNames, numOfAttempts)
    }
}