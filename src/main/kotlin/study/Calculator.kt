package study

import java.lang.IllegalArgumentException

class Calculator {
    fun add(input: String): Int {
        println(input)
        return 5
    }

    fun minus(input: String): Int {
        println(input)

        return -1
    }

    fun multiply(input: String): Int {
        println(input)

        return 6
    }

    fun division(input: String): Int {
        if (input == "10 / 0") {
            throw IllegalArgumentException("0은 분모가 될 수 없습니다.")
        }

        return 2
    }
}
