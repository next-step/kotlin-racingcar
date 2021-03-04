package racingcar_winner.model

class Winner {
    fun getWinner(cars: Cars): List<String> {
        val highScore = getHighScore(cars)
        return cars.toList().filter { car ->
            car.progress == highScore
        }.map { car ->
            car.name
        }
    }

    private fun getHighScore(cars: Cars): Int {
        return cars.toList().map {
            it.progress
        }.max()!!
    }
}
