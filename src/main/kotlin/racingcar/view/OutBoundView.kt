package racingcar.view

import racingcar.domain.GameResult
import racingcar.domain.collection.RoundRecord

class OutBoundView(
    private val print: (String) -> Unit
) {
    fun displayResult(result: GameResult) {
        print("실행 결과:\n")
        result.records.forEach(::displayResultDetails)
        print("${result.winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun displayResultDetails(result: RoundRecord) {
        result.roundRecord
            .forEach { player ->
                print(player.carName + " : ")
                repeat(player.position) {
                    print(DISPLAY_MOVEMENT)
                }
                disPlayEmptyLine()
            }
        disPlayEmptyLine()
    }

    private fun disPlayEmptyLine() = print("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}
