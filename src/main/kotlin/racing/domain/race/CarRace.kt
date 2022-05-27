package racing.domain.race

import racing.domain.common.CarRaceProperty

class CarRace(private val carRaceProperty: CarRaceProperty) {
    fun start() {
        carRaceProperty.cars.map { it.move() }
    }
}
