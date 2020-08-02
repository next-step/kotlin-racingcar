package racingCar.domain

object Winner {

    fun getRacingWinner(carsInRacing: List<Car>): String {
        val longestDistance = carsInRacing.map { it.distance }.max()
        val resultWinnerCars = carsInRacing.filter { it.distance == longestDistance }

        return getWinnersName(resultWinnerCars)
    }

    private fun getWinnersName(cars: List<Car>): String {
        var winner: String = ""

        repeat(cars.size) { index ->
            winner += cars[index].name + " "
        }
        return winner
    }
}
