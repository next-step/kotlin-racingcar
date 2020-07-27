package step3.view

fun getCarAmounts(): Int {
    println("자동차 대수는 몇 대 인가요?")
    return readLine()!!.toInt()
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회 인가요?")
    return readLine()!!.toInt()
}
