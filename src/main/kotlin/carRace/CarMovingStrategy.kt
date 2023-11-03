package carRace

interface CarMovingStrategy {
    fun shouldMove(): Boolean
}

class RandomMovingStrategy : CarMovingStrategy {
    override fun shouldMove(): Boolean = ((0..9).random() >= 4)
}
