package calculator

import java.util.Stack

interface Word {
    fun calculate(acc: Stack<Number>)
}
