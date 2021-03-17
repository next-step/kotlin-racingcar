package car.domain

class EnergyRandomMovableStrategy(
    private val energyProvider: EnergyProvider = RandomEnergyProvider()
) : MovableStrategy {
    override val movable: Boolean
        get() = energyProvider.energy >= MOVE_CONDITION_ENERGY

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
    }
}
