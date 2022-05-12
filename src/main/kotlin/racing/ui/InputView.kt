package racing.ui

class InputView {
    var carCount = 0
        private set
    var times = 0
        private set

    fun getUserInput() {
        carCount = getNumberOfCars()
        times = getNumberOfTimes()
        println()
    }

    private fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        val count = readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid Input(cars)")
        require(count > 0) { "Number of cars > 0" }
        return count
    }

    private fun getNumberOfTimes(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid Input(times)")
    }
}
