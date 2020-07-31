package carracing

object CarRacingView {

    fun getCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNames = readLine()!!
        if (inputCarNames.isBlank()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        return inputCarNames
    }

    fun getCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputCount = readLine()!!
        if (inputCount.isBlank()) {
            throw NullPointerException("숫자로 입력해주세요.")
        }
        var count: Int
        try {
            count = inputCount.toInt()
        } catch (e: NumberFormatException) {
            throw CarRacingException("숫자를 입력해주세요.")
        }
        if (count < 1) {
            throw CarRacingException("자연수를 입력해주세요.")
        }
        return count
    }

    fun showCarMovement(cars: MutableList<Car>) {
        cars.forEach {
            print(it.name + " : " + "-".repeat(it.position) + "\n")
        }
    }

    fun showWinners(winners: List<Car>) {
        val result = StringBuilder()
        winners.forEach {
            result.append(it.name).append(", ")
        }
        result.delete(result.length - 2, result.length)

        print(result.toString() + "가 최종 우승했습니다.")
    }
}
