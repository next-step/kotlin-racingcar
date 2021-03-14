package car.domain

import car.domain.EnergyProvider.Companion.MAX_ENERGY_SIZE
import kotlin.random.Random

class RandomEnergyProvider : EnergyProvider {
    override val energy: Int
        get() = Random.nextInt(MAX_ENERGY_SIZE)
}
