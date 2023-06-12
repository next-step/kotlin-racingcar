package racing.condition

class FirstRoundCondition : RacingCondition {
    override val predicate: (Int?) -> Boolean
        get() = { round -> round == 1 }
}
