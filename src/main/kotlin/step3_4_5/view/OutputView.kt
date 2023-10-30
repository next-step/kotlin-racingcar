package step3_4_5.view

object OutputView {
    fun printEnterNumberOfCarsMessage() = println(NUMBER_OF_CARS)
    fun printEnterNumberOfRoundMessage() = println(NUMBER_OF_ROUNDS)

    private const val NUMBER_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분."
    private const val NUMBER_OF_ROUNDS = "시도할 횟수는 몇 회인가요?"
}
