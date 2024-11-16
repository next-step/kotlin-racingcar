package race

class RaceResultView {
    companion object {
        private const val PROGRESS_UNIT = "-"
    }

    fun printResult(result: RaceResult) {
        println("실행 결과")

        result.rounds.forEach {
            progressPrint(it)
            println()
        }

        val winners = result.winners
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun progressPrint(it: RaceRound) {
        it.positions.forEach {
            println("${it.displayName} : ${PROGRESS_UNIT.repeat(it.progress)}")
        }
    }
}
