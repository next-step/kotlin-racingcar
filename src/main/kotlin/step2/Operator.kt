package step2

enum class Operator (val symbol: String, val operator: (left: Int, right: Int) -> Int) {

    PLUS("+", { left, right -> left + right });

    companion object {
        //
    }
}