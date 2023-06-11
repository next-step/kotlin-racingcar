fun main() {
    val inputIO = InputIO()
    val racingField = RacingField()
    val resultView = ResultView()

    racingField.createCars(
        inputIO.inputNumber(InputType.CAR_COUNT)
    )

    racingField.setGameCount(
        inputIO.inputNumber(InputType.GAME_COUNT)
    )

    for (i in 1..racingField.getGameCount()) {
        resultView.carDistanceDisplay(racingField.gameStart())
    }
}
