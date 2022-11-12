package racingcar

class CarRecorder() {
    private val record = mutableMapOf<Int, List<Car>>()

    fun recording(turn: Int, cars: List<Car>) {
        if (cars.isEmpty()) throw IllegalArgumentException("자동차 결과가 없습니다.")
        record[turn] = cars
    }

    fun findWinners(lastTurn: Int): List<String> {
        val records = getCarRecords(lastTurn)
        val winningScore = records.maxOf { it.currentPosition }

        return records
            .filter { it.currentPosition == winningScore }
            .map { it.name }
    }

    private fun getCarRecords(lastTurn: Int) =
        record[lastTurn] ?: throw IllegalArgumentException("게임 결과가 없습니다.")
}
