package com.jay.racingcar.domain

import kotlin.streams.toList

class Names(nameString: List<String>) {
    private val names: List<Name> = nameString.stream().map { Name(it) }.toList()

    fun size(): Int = names.size

    fun get(index: Int) = names[index]
}
