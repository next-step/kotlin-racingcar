package racing

import racing.application.ApplicationForm

object InputView {
    fun writeApplicationForm(): ApplicationForm {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val participants = readLine()!!

        return ApplicationForm.write(participants)
    }

    fun inputRunCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}