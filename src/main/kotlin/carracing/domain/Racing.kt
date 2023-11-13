package carracing.domain

class Racing(
    val cars: List<Car>,
    val rule: Rule = Rule.RandomRule()
) {
    var isFinish = false
        private set
    val winners: List<String> by lazy { decideWinner() }

    private fun decideWinner(): List<String> {
        check(isFinish) { "'winners' can only be determined after racing finish" }
        val maxCount = cars.maxOf { it.movingCount }
        return cars
            .filter { it.movingCount == maxCount }
            .map { it.name }
    }

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

    fun finish(): List<String> {
        check(!isFinish) { "racing has already finished" }
        isFinish = true
        return winners
    }
}
