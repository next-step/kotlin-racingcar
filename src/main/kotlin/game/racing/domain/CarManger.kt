package game.racing.domain

import game.racing.util.getRandomValue

class CarManger(val cars: List<Car> = mutableListOf()) {

    fun moveCars() {
        cars.forEach {
            it.move(getRandomValue())
        }
    }
}
