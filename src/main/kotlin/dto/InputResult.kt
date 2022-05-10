package dto

import model.Car

data class InputResult(val round: Int, val player: Int) {
    val cars: List<Car> = (1..player).map { Car.spawnAt(0) }
}
