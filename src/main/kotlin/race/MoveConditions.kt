package race

data class MoveConditions(private val values: List<MoveCondition>) : List<MoveCondition> by values {
    constructor(count: Int, generator: NumberGenerator) : this(List(count) { MoveCondition(generator()) })
}
