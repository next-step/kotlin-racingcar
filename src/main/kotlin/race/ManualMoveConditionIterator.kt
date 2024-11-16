package race

class ManualMoveConditionIterator(
    private val moveConditions: List<MoveCondition>,
    private var currentIndex: Int = 0,
) : RaceIterator<MoveCondition> {
    override fun hasNext(): Boolean {
        return currentIndex < moveConditions.size
    }

    override fun next(): MoveCondition {
        return moveConditions[currentIndex++]
    }
}
