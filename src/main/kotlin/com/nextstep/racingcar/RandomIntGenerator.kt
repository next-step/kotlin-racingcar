package com.nextstep.racingcar

class RandomIntGenerator : NumberGenerator {

    override fun generate(): Int {
        val range = 0..9
        return range.random()
    }
}
