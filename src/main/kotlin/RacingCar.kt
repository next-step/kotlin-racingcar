package com.racingCar.mainKt

fun inputCarNames(): List<String>{
    val cars = readlnOrNull()?.split(",")?: listOf()
    if (cars.find { it.length > 5 } == null &&
        cars.isNotEmpty()) {
        return cars
    }
    throw IllegalArgumentException("[ERROR] Invalid argument.")
}

fun initRaces(): MutableMap<String, Int> {
    var cars : List<String>
    while(true){
        try {
            cars = inputCarNames()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    return cars.associateWith { 0 }.toMutableMap()
}

fun getRandValue(): Int {
    val range = kotlin.random.Random.nextInt(0, 10)
    return when(range) {
        in 4..9 -> 1
        else -> 0
    }
}

fun runRaces(races: MutableMap<String, Int>, count: Int) {
    for (i in 0 until count) {
        for (race in races) {
            race.setValue(race.value + getRandValue())
            printRace(race)
        }
        println()
    }
}

fun printRace(race: MutableMap.MutableEntry<String, Int>) {
    print(race.key + " : ")
    for (j in 0 until race.value) {
        print("-")
    }
    println()
}

fun getWinners(races: MutableMap<String, Int>): String {
    val maxValue = races.values.maxOrNull()
    val maxKeys = races.filter { it.value == maxValue }.keys
    return maxKeys.joinToString(", ")
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val races = initRaces()

    println("시도할 회수는 몇회인가요?")
    val count = readlnOrNull()?.toInt()?: 0

    println("실행 결과")
    runRaces(races, count)

    println("최종 우승자 : " + getWinners(races))
}