package race

typealias isMove = Boolean

data class MoveConditions(private val values: List<isMove>) : List<isMove> by values {
    constructor(count: Int, generator: NumberGenerator) : this(List(count) { MoveCondition.shouldMove(generator()) })
}
