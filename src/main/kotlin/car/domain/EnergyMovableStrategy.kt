package car.domain

class EnergyMovableStrategy(private val energyProvider: EnergyProvider = RandomEnergyProvider()) : MovableStrategy {
    override fun isMovable(): Boolean {
        return energyProvider.energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
    }
}
