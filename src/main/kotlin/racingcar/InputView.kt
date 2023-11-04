package racingcar

data class InputView(
    var gameCount: Int = 0,
    var cars: List<Car> = listOf()
) {
    fun inputGameCount() {
        println("시도할 회수는 몇회인가요?")
        val input = readln().toInt()
        validate(input)
        this.gameCount = input
    }

    fun inputCarNumber() {
        println("자동차 대수는 몇 대 인가요?")
        val input = readln().toInt()
        validate(input)

        this.cars = List(input) {
            Car(moveCondition = RandomNumberHolderImpl())
        }
    }

    fun validate(input: Int) {
        require(input > 0) { throw IllegalArgumentException("음수는 입력할 수 없습니다.") }
    }
}
