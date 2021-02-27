package calculator

import java.lang.IllegalArgumentException
import java.util.stream.Stream

enum class Operation(val operationString: String, val operate: (Int, Int) -> Int) {
    PLUS("+", { first: Int, second: Int -> first + second }),
    MINUS("-", { first: Int, second: Int -> first - second }),
    MULTIPLE("*", { first: Int, second: Int -> first * second }),
    DIVIDE("/", { first: Int, second: Int -> first / second });

    fun calc(first: Int, second: Int) : Int {
        return operate(first, second);
    }

    companion object {
        @JvmStatic
        fun operationOf(operation: String): Operation {
            return values().firstOrNull { item -> item.operationString == operation } ?: throw IllegalArgumentException()
        }
    }
}