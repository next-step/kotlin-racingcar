package dto

import gameobj.Car

data class InputResult(val round: Int, val player: Int) {
    val cars: List<Car> = (1..player).map { Car.spawn() }
}
