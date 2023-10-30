package racing.view

class InputView {
    fun participates(): ArrayDeque<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return ArrayDeque(
            requireNotNull(readlnOrNull()) { "공백은 허용되지 않습니다" }
                .split(",")
        )
    }

    fun roundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
