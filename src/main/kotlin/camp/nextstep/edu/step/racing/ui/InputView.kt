package camp.nextstep.edu.step.racing.ui

object InputView {

    fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine() ?: throw IllegalArgumentException("차 이름이 올바르지 않습니다.")
    }

    fun inputTryCount(): Int {
        println("시도할 회수는 몇회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")
    }

    fun inputTournamentName(): String {
        println("경주할 대회 이름을 입력하세요.")
        return readLine() ?: throw IllegalArgumentException("대회명이 올바르지 않습니다.")
    }

    fun inputTrackName(): String {
        println("경주할 트랙 이름을 입력하세요.")
        return readLine() ?: throw IllegalArgumentException("옳은 트랙 이름이 아닙니다.")
    }

}
