package nexstep.mission.racingcar.io

object ConsoleInput : Input {

    override fun inputRacingCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    override fun inputRacingGames(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
