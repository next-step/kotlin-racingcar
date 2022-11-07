package nexstep.mission.racingcar.io

object ConsoleOutput : Output {

    override fun printPositions(dto: List<RacingCarDto>) {
        dto.forEach { println("${it.name}: ${"-".repeat(it.position)}") }
        println()
    }

    override fun printWinner(winners: List<String>) {
        println("${winners.joinToString(",")}가 최종 우승했습니다.")
    }
}
