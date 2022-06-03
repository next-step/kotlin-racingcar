package com.nextstep.jngcii.racingcar.domain

class Winners(cars: Cars) {
    val cars = cars
        .nameToDistanceMap
        .maxOf { it.value }.let { cars.filterBy(it) }
}
