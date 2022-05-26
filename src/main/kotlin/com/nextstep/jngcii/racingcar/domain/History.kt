package com.nextstep.jngcii.racingcar.domain

class History(private val cars: Cars) {
    private val _records = mutableListOf<Record>()
    val records get() = _records.toList()

    val winners
        get(): List<String> {
            val maxDistance = cars
                .nameToDistanceMap
                .maxOf { it.value }

            return cars.getNames(maxDistance)
        }

    fun write() {
        val record = Record(cars.nameToDistanceMap)
        _records.add(record)
    }
}
