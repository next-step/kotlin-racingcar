package camp.nextstep.edu.step3.racing

import kotlin.random.Random

class RandomlyEngine : Engine {

    private val random = Random(seed)

    init {
        seed = Random.Default.nextInt()
    }

    override fun speed(): Int {
        return if (random.nextInt(0, 10) >= 4) 1 else 0
    }

    companion object {
        private var seed = Random.Default.nextInt()
    }
}
