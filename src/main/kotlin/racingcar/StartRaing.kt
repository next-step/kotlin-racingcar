package racingcar

import java.lang.Exception
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val game = Game()
    do {
        try {
            println("자동차 대수는 몇 대인가요?")
            val inputCarNum = inputInt()
            println("시도할 횟수는 몇 회인가요?")
            val inputMoveTime = inputInt()
            game.readyGame(inputCarNum, inputMoveTime)
            game.startGame()
            break
        } catch (e: Exception) {
            println(e.message)
        }
    } while (true)
}

fun inputInt(): Int {
    try {
        return readLine()!!.toInt()
    } catch (e: Exception) {
        throw NumberFormatException("숫자를 입력해주세요!!")
    }
}
