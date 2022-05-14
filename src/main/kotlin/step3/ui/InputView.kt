package step3.ui

object InputView {
    fun askCarCount(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        return readln()
    }

    fun askMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력이 가능합니다.(시도 회수)")
    }
}
