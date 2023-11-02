package racingcar.domain

import racingcar.domain.car.Car

object CarRacingReferee {
    fun getWinners(cars: List<Car>): List<Car> =
        cars.fold(mutableListOf()) { winners, car -> determineWinner(winners, car) }

    private fun determineWinner(winners: MutableList<Car>, car: Car): MutableList<Car> {
        when {
            winners.isEmpty() -> winners.add(car)
            car.isWin(winners[0]) -> winners.apply { clear() }.add(car)
            car.isDraw(winners[0]) -> winners.add(car)
        }
        return winners
    }
}
