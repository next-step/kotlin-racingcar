package com.nextstep.jngcii.racingcar.domain

class History(val cars: Cars) {
    private val _records = mutableListOf<Record>()
    val records get() = _records.toList()

    fun write() {
        val distanceByName = mutableMapOf<String, Int>()
        cars.forEach { distanceByName[it.name] = it.distance }

        val record = Record(distanceByName)
        _records.add(record)
    }
}
