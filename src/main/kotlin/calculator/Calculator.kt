package calculator

import java.lang.IllegalArgumentException

class Calculator(private val calculate : String?) {
    fun calc() {
        require(!calculate.isNullOrBlank());
    }
}