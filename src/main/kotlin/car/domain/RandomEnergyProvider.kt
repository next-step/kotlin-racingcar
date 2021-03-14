package car.domain

import car.domain.EnergyProvider.Companion.MAX_ENERGY_SIZE
import kotlin.random.Random

class RandomEnergyProvider : EnergyProvider {
    override fun createNewEnergy(): Int {
        return Random.nextInt(MAX_ENERGY_SIZE)
    }
}
