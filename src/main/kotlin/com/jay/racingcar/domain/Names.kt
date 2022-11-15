package com.jay.racingcar.domain

import kotlin.streams.toList

class Names(nameInputs: List<String>) {
    private val names: List<Name> = nameInputs.stream().map { Name(it) }.toList()

    fun size(): Int = names.size

    fun get(index: Int) = names[index]
}
