package car.domain

interface EnergyProvider {
    val energy: Int

    companion object {
        const val MAX_ENERGY_SIZE = 10
    }
}
