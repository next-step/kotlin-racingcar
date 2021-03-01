package car.business

import car.energy.EnergyProvider
import car.energy.RandomEnergyProvider

class Cars(amount: Int, energyProvider: EnergyProvider = RandomEnergyProvider()) {

    private val cars: List<Car> = (1..amount).map { Car() }
    private val energyProvider: EnergyProvider = energyProvider

    fun move(): Int {
        return cars.count { it.move(energyProvider.getEnergy()) }
    }

    fun getPositions(): List<Int> {
        return cars.map { it.currentPosition }
    }
}
