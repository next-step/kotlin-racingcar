package race

fun main() {
    val carNamesView = InputView("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val retryCountView = InputView("시도할 횟수는 몇 회인가요?")
    val resultView = RaceResultView()

    val raceBoard =
        RaceFactory.createRaceBoard(
            Cars(Names(carNamesView.processInput())),
            PositiveNumber(retryCountView.processInput()),
        )

    resultView.printResult(raceBoard.start())
}
