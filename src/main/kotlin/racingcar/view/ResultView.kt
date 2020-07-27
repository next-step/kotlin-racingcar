package racingcar.view

import racingcar.model.Participants

object ResultView {
    private const val RESULT = "실행 결과"

    fun printResultTitle() {
        println(RESULT)
    }

    fun printParticipantsPath(participants: Participants) {
        println(participants.getMovingStatus())
    }
}
