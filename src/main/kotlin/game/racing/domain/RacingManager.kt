package game.racing.domain

class RacingManager(val cars: List<Car>) {

    fun moveCars(speedList: List<Int>) {
        cars.forEachIndexed { index, car ->
            car.moveOrStayBySpeed(speedList[index])
        }
    }

    fun getWinners(): List<Car> {
        val winnersPair = Pair(Car.MIN_POSITION, mutableListOf<Car>())
        return cars.fold(winnersPair) { acc, car ->
            if (car.position > acc.first) {
                Pair(car.position, mutableListOf(car))
            } else if (car.position == acc.first) {
                acc.second.add(car)
                acc
            } else {
                acc
            }
        }.second
    }
}
