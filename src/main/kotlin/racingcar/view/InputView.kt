package racingcar.view

object InputView {
    fun gatherUserInput(): Pair<Int, Int> {
        ConsolePrinter.printMsg("자동차 대수는 몇 대인가요?")
        val numOfCars = ConsoleReader.readInput()

        ConsolePrinter.printMsg("시도할 횟수는 몇 회인가요?")
        val numOfAttempts = ConsoleReader.readInput()

        return Pair(numOfCars, numOfAttempts)
    }
}