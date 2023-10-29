package study.racingcar

class InputView(private val inputProvider: InputProvider) {
    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return inputProvider.provideInput().toIntOrNull() ?: 0
    }

    fun getNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return inputProvider.provideInput().toIntOrNull() ?: 0
    }
}
