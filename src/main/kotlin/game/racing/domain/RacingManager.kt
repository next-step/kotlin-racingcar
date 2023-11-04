package game.racing.domain

class RacingManager(val cars: List<Car>) {

    fun moveCars(speedList: List<Int>) {
        cars.forEachIndexed { index, car ->
            car.moveOrStayBySpeed(speedList[index])
        }
    }
}
