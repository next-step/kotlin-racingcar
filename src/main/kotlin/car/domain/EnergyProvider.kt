package car.domain

interface EnergyProvider {
    fun getEnergy(): Int

    companion object {
        const val MAX_ENERGY_SIZE = 10
    }
}
