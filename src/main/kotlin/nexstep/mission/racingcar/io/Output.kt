package nexstep.mission.racingcar.io

interface Output {

    fun printPositions(dto: List<RacingCarDto>)

    fun printWinner(winners: List<String>)
}
