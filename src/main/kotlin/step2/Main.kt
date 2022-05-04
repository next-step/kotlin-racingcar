package step2

import step2.calculator.Calculator

fun main(){
    println("type input string")
    val inputString = readLine()
    val result = Calculator().calculate(inputString)

    println(result)
}