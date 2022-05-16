package racing

interface Random {
    fun getNumber(): Int
}

class RandomImpl : Random {
    private val distanceRange = (0..10)
    override fun getNumber(): Int = distanceRange.random()
}

class DistanceService(private val random: RandomImpl = RandomImpl()) {
    private val standardDistance = 4

    fun get(): Int {
        val randomDistance = random.getNumber()
        return when {
            randomDistance >= standardDistance -> randomDistance
            else -> 0
        }
    }
}
