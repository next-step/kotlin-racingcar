package study.step3.domain

import kotlin.random.Random

interface CarEngine {
    fun run(): Int
}

class RandomSeedEngine : CarEngine {
    override fun run(): Int {
        return if (Random.nextInt(0, 10) > 4) 1 else 0
    }
}

class BrokenEngine : CarEngine {
    override fun run(): Int {
        return 0
    }
}

class NormalEngine : CarEngine {
    override fun run(): Int {
        return 1
    }
}
