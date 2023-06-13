package racinggame.domain.car.engine

class RandomEnergyEngine(
    private val randomNumberGenerator: RandomNumberGenerator
) : Engine {

    override fun execute(): DrivableDistance {
        val energy = randomNumberGenerator.generate(MINIMUM_ENERGY..MAXIMUM_ENERGY)
        return DrivableDistance(if (energy >= MINIMUM_REQUIRE_ENERGY) FIXED_DRIVABLE_DISTANCE else 0)
    }

    companion object {
        private const val MINIMUM_ENERGY = 0
        private const val MAXIMUM_ENERGY = 9
        private const val MINIMUM_REQUIRE_ENERGY = 4
        private const val FIXED_DRIVABLE_DISTANCE = 1
    }
}
