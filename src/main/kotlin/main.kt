fun main() {
    val inputIO = InputIO()
    val racingField = RacingField()

    racingField.createCars(
        inputIO.inputNumber(InputType.CAR_COUNT)
    )

    racingField.setGameCount(
        inputIO.inputNumber(InputType.GAME_COUNT)
    )

    racingField.gameStart()
}
