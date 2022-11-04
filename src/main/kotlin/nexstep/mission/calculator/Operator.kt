package nexstep.mission.calculator

enum class Operator(val symbol: String, val operate: (Int, Int) -> Int) {

    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLE("*", { x, y -> x * y }),
    DIVISION("/", { x, y ->
        require(y != 0) { "0으로 나눌 수 없습니다." }
        x / y
    });

    companion object {
        fun find(symbol: String): Operator = values()
            .find { it.symbol == symbol } ?: throw IllegalArgumentException("사칙 연산 기호가 잘못됐습니다.")
    }
}
