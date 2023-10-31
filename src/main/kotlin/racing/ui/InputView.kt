package racing.ui

object InputView {

    fun inputPlayers(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun inputGameCount(): Int {
        println("시도할 회수는 몇회인가요?")
        return readln().toInt()
    }
}
