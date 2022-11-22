package com.nextstep.racingcar.domain.rules

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        val range = 0..9
        return range.random()
    }
}
