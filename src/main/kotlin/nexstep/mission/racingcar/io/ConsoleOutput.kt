package nexstep.mission.racingcar.io

object ConsoleOutput : Output {

    override fun output(dto: List<RacingCarDto>) {
        dto.forEach { println("-".repeat(it.position)) }
        println()
    }
}
