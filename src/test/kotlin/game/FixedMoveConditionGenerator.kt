package game

class FixedMoveConditionGenerator(private val count: Int) : MoveConditionGenerator {
    override fun generate(): Int = count
}
