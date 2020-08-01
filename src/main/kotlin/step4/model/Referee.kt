package step4.model

class Referee {
    fun getWinner(cars: List<Car>): String {
        val max = cars.map { it.raceResult }.max()
        cars.filter { it.raceResult == max }

        return getWinnersName(cars)
    }

    private fun getWinnersName(cars: List<Car>): String {
        var winner = cars[0].name

        for (i in 1 until cars.size) {
            winner += ","
            winner += cars[i].name
        }
        return winner
    }
}
