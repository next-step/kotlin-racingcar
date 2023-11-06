package racing.view

import calculator.model.Tokenizer
import racing.model.Car
import racing.model.Name
import racing.model.RoundHistory

class InputView {
    fun participates(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputParticipates = requireNotNull(readlnOrNull()) { "공백은 허용되지 않습니다" }
        assertValidParticipateNames(inputParticipates)
        return inputParticipates
    }

    private fun assertValidParticipateNames(requireNotNull: String) {
        RoundHistory(
            Tokenizer.toTokens(requireNotNull)
                .map { Car(Name(it), 0) }
        )
    }

    fun roundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
