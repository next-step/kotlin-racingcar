package racing

import racing.application.ApplicationForm

object InputView {
    fun writeApplicationForm(): ApplicationForm {
        print("자동차 대수는 몇 대인가요?")
        val participantSize = readLine()!!.toInt()

        return ApplicationForm(participantCount = participantSize)
    }

    fun inputRunCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}