package step3.UI

object InputView {
    fun writeCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력이 가능합니다.(자동차 대수)")
    }

    fun writeMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력이 가능합니다.(시도 회수)")
    }
}
