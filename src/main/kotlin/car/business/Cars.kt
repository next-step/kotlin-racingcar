package car.business

import car.energy.EnergyProvider
import car.energy.RandomEnergyProvider

class Cars(names: List<String>, energyProvider: EnergyProvider = RandomEnergyProvider()) {

    private val cars: List<Car> = names.map { Car(it) }
    private val energyProvider: EnergyProvider = energyProvider

    internal var allHistories: MutableList<CarMoveHistoryCollection> = ArrayList()
        private set

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        val histories = CarMoveHistoryCollection()
        cars.forEach {
            it.move(energyProvider.getEnergy())

            var carMoveHistory = CarMoveHistory(it, it.currentPosition)
            histories.add(carMoveHistory)
        }

        allHistories.add(histories)
    }
}
