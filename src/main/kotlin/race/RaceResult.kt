package race

data class RaceResult(val rounds: List<RaceRound>) {
    val winners: List<String>
        get() {
            val lastRoundPositions = rounds.last().positions
            val maxProgress = lastRoundPositions.maxOfOrNull { it.progress }

            return lastRoundPositions
                .filter { it.progress == maxProgress }
                .map { it.displayName }
        }
}
