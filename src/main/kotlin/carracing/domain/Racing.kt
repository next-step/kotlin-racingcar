package carracing.domain

class Racing(
    val cars: List<Car>,
    val rule: Rule = Rule.RandomRule()
) {
    var isFinish = false
        private set
    val winners: List<String> by lazy {
        when (isFinish) {
            true -> {
                val maxCount = cars.maxOf { it.movingCount }
                cars
                    .filter { it.movingCount == maxCount }
                    .map { it.name }
            }

            false -> throw IllegalStateException("'winners' can only be determined after racing finish")
        }
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
        if (isFinish) {
            throw IllegalStateException("racing has already finished")
        }
        isFinish = true
        return winners
    }
}
