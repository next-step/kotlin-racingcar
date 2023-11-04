package racingcar

data class InputView(
    var gameCount: Int = 0,
    var cars: List<Car> = listOf()
) {
    fun inputGameCount(): Unit {
        println("시도할 회수는 몇회인가요?")
        val input = readln().toInt()
        validate()

        this.gameCount = input
    }

    fun inputCarNumber() {
        println("자동차 대수는 몇 대 인가요?")
        val input = readln().toInt()
        validate()

        this.cars = List(input) {
            Car(moveCondition = RandomNumberHolderImpl())
        }
    }

    private fun validate() {
        require(gameCount < 0) { throw IllegalArgumentException("음수는 입력할 수 없습니다.") }
        require(gameCount > 100) { throw IllegalArgumentException("100회 이상은 입력할 수 없습니다.") }
    }
}
