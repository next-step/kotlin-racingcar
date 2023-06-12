package racing.condition

interface RacingCondition {
    val predicate: (Int?) -> Boolean
}
