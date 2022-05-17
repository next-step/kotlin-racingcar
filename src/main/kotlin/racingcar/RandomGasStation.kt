package racingcar

object RandomGasStation {
    fun refuels(count: Int): List<Int> {
        return List(count) { refuel() }
    }

    private fun refuel(): Int {
        return IntRange(0, 9).random()
    }
}
