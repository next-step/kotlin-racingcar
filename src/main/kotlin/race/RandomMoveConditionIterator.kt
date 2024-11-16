package race

class RandomMoveConditionIterator(
    private val maxCount: Int,
    private val randomGenerate: RandomGenerate,
) : RaceIterator<MoveCondition> {
    private var currentIndex: Int = 0

    override fun hasNext(): Boolean {
        return currentIndex < maxCount
    }

    override fun next(): MoveCondition {
        currentIndex++
        return MoveCondition(randomGenerate.generate())
    }
}
