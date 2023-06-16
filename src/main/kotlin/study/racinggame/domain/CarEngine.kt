package study.racinggame.domain

import kotlin.random.Random

interface CarEngine {
    fun run(): Boolean
}

object RandomSeedEngine : CarEngine {
    override fun run(): Boolean {
        return Random.nextInt(0, 10) > 4
    }
}
