package racingcar.view


object InputView {

    private var participant: Int = 0
    private var times: Int = 0
    fun registerParticipant() {
        println("자동차 대수는 몇 대인가요 ?")
        participant = readLine()!!.toInt()
        require(participant != 0) { "0대의 차로는 시작할 수 없습니다." }
    }

    fun getParticipant() = participant

    fun setNumberOfTimes() {
        println("시도할 횟수는 몇 회인가요?")
        times = readLine()!!.toInt()
        require(times != 0) { "0번의 횟수를 시도할 수 없습니다." }
    }

    fun getNumberOfTimes() = times
}
