package camp.nextstep.edu.step3

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
        for (i in 0..to) {
            if (track.isPassedAt(i)) print("⎼ ")
        }
        println()
    }

    fun drawBlank() = println()
}
