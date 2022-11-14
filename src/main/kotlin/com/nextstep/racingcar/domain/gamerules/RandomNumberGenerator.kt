package com.nextstep.racingcar.domain.gamerules

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        val range = 0..9
        return range.random()
    }
}
