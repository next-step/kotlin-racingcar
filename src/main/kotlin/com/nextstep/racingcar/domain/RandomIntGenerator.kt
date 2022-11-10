package com.nextstep.racingcar.domain

class RandomIntGenerator : NumberGenerator {

    override fun generate(): Int {
        val range = 0..9
        return range.random()
    }
}
