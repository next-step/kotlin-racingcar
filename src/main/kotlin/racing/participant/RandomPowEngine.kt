package racing.participant

import kotlin.random.Random

class RandomPowEngine : Engine {

    override fun enoughEnergy(): Boolean {
        return Random.nextInt(MAX_ENERGY) >= MINIMUM_ENERGY
    }

    companion object {
        private const val MAX_ENERGY = 10
        private const val MINIMUM_ENERGY = 4
    }
}