package racingCar

fun main() {
    val inputIO = InputIO()
    val carCount = inputIO.inputNumber(InputType.CAR_COUNT)
    val gameCount = inputIO.inputNumber(InputType.GAME_COUNT)

    val racingField = RacingField(carCount, gameCount)

    val resultView = ResultView()

    repeat(gameCount) {
        racingField.gameStart()
        resultView.racingResultDisplay(racingField.getCarsDistance())
    }
}
