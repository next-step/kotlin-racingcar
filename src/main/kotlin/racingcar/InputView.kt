package racingcar

import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)
    val carCount: Int
    val playCount: Int

    init {
        print("자동차 대수는 몇대인가요? ")
        carCount = scanner.nextInt()
        print("시도할 횟수는 몇회인가요? ")
        playCount = scanner.nextInt()
    }
}
