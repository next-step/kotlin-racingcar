package racing.view

object InputView {

    fun inputNamesOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val input = readLine()
        require(!input.isNullOrBlank()) { "자동차 이름은 1개 이상 입력해주셔야 합니다." }

        return input.split(",").map(String::trim)
    }

    fun inputNumOfMove(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val numOfMove = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 숫자값으로 입력해주세요.")
        require(numOfMove > 0) { "시도할 횟수는 0보다 커야합니다." }

        return numOfMove
    }
}
