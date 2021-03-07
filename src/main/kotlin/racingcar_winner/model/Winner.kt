package racingcar_winner.model

class Winner(
    private val cars: Cars
) {
    fun getWinner(): List<String> {
        val highScore = getHighScore()
        return cars.toList().filter { car ->
            car.progress == highScore
        }.map { car ->
            car.name
        }
    }

    private fun getHighScore(): Int {
        return cars.toList().map {
            it.progress
        }.max()!!
    }
}
