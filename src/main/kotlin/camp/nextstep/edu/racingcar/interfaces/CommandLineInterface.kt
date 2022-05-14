package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Track

class CommandLineInterface {

    fun readCarNumber(): Int {
        println("자동차 대수는 몇 대인가요?")
        return requireNotNull(readLine()?.toInt())
    }

    fun readMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return requireNotNull(readLine()?.toInt())
    }

    fun drawTrackTo(track: Track, to: Int) {
        val traces = track.traces()
        for (i in 0..to) {
            if (traces.next()) print("⎼ ")
        }
        println()
    }

    fun drawBlank() = println()
}
