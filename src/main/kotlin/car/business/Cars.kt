package car.business

import car.energy.EnergyProvider
import car.energy.RandomEnergyProvider

class Cars(amount: Int, energyProvider: EnergyProvider = RandomEnergyProvider()) {

    private val cars: List<Car> = (1..amount).map { Car() }
    private val energyProvider: EnergyProvider = energyProvider

    internal var allHistories: MutableList<CarMoveHistories> = ArrayList()
        private set

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        val histories = CarMoveHistories()
        cars.forEach {
            it.move(energyProvider.getEnergy())

            var carMoveHistory = CarMoveHistory(it, it.currentPosition)
            histories.add(carMoveHistory)
        }

        allHistories.add(histories)
    }
}
