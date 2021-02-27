package calculator

import java.lang.IllegalArgumentException

class Calculator(private val calculate : String?) {
    fun calc() {
        if(calculate.isNullOrBlank()) throw IllegalArgumentException("공백 또는 Null은 계산이 불가능합니다.")
    }
}