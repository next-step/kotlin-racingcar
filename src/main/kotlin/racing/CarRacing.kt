package racing

import kotlin.random.Random

fun main() {
    val input = inputView()
    move(input)
    resultView(input)
}

private fun inputView(): List<MutableList<Int>> {
    println("자동차 대수는 몇 대인가요?")
    val carSize = readln().toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readln().toInt()
    return List(tryCount) { MutableList(carSize) { 1 } }
}

private fun move(input: List<MutableList<Int>>) {
    input.forEachIndexed { i, cars ->
        cars.forEachIndexed { i1, _ ->
            Random.nextInt(10).takeIf { it >= 4 }?.let {
                for (i2 in i until input.size) {
                    input[i2][i1] += 1
                }
            }
        }
    }
}

private fun resultView(input: List<List<Int>>) {
    println("실행 결과")
    input.forEach { cars ->
        cars.forEach { location ->
            for (i in 0 until location) {
                print("-")
            }
            println()
        }
        println()
    }
}
