package nexstep.mission.calculator

enum class Operation(val operator: String, val calculator: (Int, Int) -> Int) {

    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLE("*", { x, y -> x * y }),
    DIVISION("/", { x, y ->
        require(y != 0) { "0으로 나눌 수 없습니다." }
        x / y
    });

    companion object {
        fun find(operator: String): Operation = values()
            .find { it.operator == operator } ?: throw IllegalArgumentException("사칙 연산 기호가 잘못됐습니다.")
    }
}
