package car.energy

import car.energy.EnergyProvider.Companion.MAX_ENERGY_SIZE
import kotlin.random.Random

class RandomEnergyProvider : EnergyProvider {
    override fun getEnergy(): Int {
        return Random.nextInt(MAX_ENERGY_SIZE)
    }
}
