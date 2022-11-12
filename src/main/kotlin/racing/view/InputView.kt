package racing.view

object InputView {

    fun inputNumOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")

        val numOfCars = readLine()!!.toIntOrNull() ?: throw IllegalArgumentException("자동차 대수는 숫자값으로 입력해주세요.")
        require(numOfCars > 0) { "자동차 대수는 0보다 커야합니다." }

        return numOfCars
    }

    fun inputNumOfMove(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val numOfMove = readLine()!!.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 숫자값으로 입력해주세요.")
        require(numOfMove > 0) { "시도할 횟수는 0보다 커야합니다." }

        return numOfMove
    }
}
