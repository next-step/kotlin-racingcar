package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Track

class CommandLineInterface {

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return requireNotNull(readLine()?.split(","))
    }

    fun readMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return requireNotNull(readLine()?.toInt())
    }

    fun draw(car: Car, track: Track, to: Int) {
        print("${car.name}\t: ")
        val traces = track.traces()
        for (i in 0..to) {
            if (traces.next()) print("⎼ ")
        }
        println()
    }

    fun drawWinner(winners: List<Car>) {
        print("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    fun drawBlank() = println()
}
