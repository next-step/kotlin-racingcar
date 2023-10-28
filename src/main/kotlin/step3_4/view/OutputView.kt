package step3_4.view

object OutputView {
    fun printEnterNumberOfCarsMessage() = println(NUMBER_OF_CARS)
    fun printEnterNumberOfRoundMessage() = println(NUMBER_OF_ROUNDS)

    private const val NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?"
    private const val NUMBER_OF_ROUNDS = "시도할 횟수는 몇 회인가요?"
}
