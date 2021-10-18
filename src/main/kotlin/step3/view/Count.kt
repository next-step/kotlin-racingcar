package step3.view

enum class Count : () -> String? {
    CAR {
        override fun invoke(): String? {
            println("자동차 대수는 몇 대인가요?")
            return readLine()
        }
    },
    ROUND {
        override fun invoke(): String? {
            println("시도할 횟수는 몇 회인가요?")
            return readLine()
        }
    };
}
