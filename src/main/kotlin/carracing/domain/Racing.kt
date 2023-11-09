package carracing.domain

class Racing(
    val cars: List<Car>,
    val rule: Rule = Rule.RandomRule()
) {

    fun playRound() {
        cars.forEach { it.move(rule.generateMovingFactor()) }
    }

    fun takeSnapshot(): Snapshot = Snapshot(cars.associate { it.name to it.movingCount } as LinkedHashMap)

    fun playRoundWithSnapshot(): Snapshot {
        playRound()
        return takeSnapshot()
    }

    fun playRoundsWithSnapshots(numberOfAttempt: Int): List<Snapshot> =
        generateSequence { playRoundWithSnapshot() }
            .take(numberOfAttempt)
            .toList()
}
