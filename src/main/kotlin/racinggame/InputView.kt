package racinggame

class InputView {
    private val racingCarValue: List<Car>
    private val racingGameTryValue: Int

    init {
        println("Input : How many racing car?")
        racingCarValue =
            arrayOfNulls<Car>(readlnOrNull()?.toIntOrNull() ?: 0).mapIndexed { idx, _ ->
                Car(name = idx.toString())
            }

        println("\nInput : How many try racing?")
        racingGameTryValue = readlnOrNull()?.toIntOrNull() ?: 0

        check(racingCarValue.isNotEmpty() && racingGameTryValue != 0) {
            "Game End"
        }
    }

    fun getJoinPlayCar(): List<Car> = racingCarValue
    fun getPlayingGameCount(): Int = racingGameTryValue
}