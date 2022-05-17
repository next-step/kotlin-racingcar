package step3

import step3.ui.InputView
import step3.ui.ResultView

fun main() {

    // for debugging
    //    val carCount = 5
    //    val raceRound = 5

    val raceInfo: Pair<Int, Int>
    try {
        raceInfo = InputView.getRaceInfo()
    } catch (e: NumberFormatException) {
        // 올바른 값 입력 필요
        println("wrong input")
        return
    } catch (e: NullPointerException) {
        // 올바른 값 입력 필요
        println("wrong input")
        return
    }

    val carCount = raceInfo.first
    val raceRound = raceInfo.second

    val raceSeries = RaceSeries(carCount, raceRound)
    val raceResult = raceSeries.start()

    ResultView.show(raceResult, carCount)

}


