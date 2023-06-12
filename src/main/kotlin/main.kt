fun main() {
    val inputIO = InputIO()
    val carCount = inputIO.inputNumber(InputType.CAR_COUNT)
    val gameCount = inputIO.inputNumber(InputType.GAME_COUNT)

    val racingField = RacingField(carCount, gameCount)

    val resultView = ResultView()
    resultView.resultMessage()

    repeat(racingField.getGameCount()) {
        resultView.carDistanceDisplay(racingField.gameStart())
    }
}
