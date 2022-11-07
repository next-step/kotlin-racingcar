package nexstep.mission.racingcar.io

object ConsoleInput : Input {

    override fun inputRacingCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    override fun inputRacingCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln()
    }

    override fun inputRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
