package com.kotlin.racingcar.domain

import io.kotest.core.spec.style.FunSpec
import org.assertj.core.api.Assertions.assertThat

class DistanceTest : FunSpec({
    test("test") {
        assertThat("").isEmpty()
        assertThat(" ").isNotEmpty
        assertThat("a").isNotEmpty()
    }

    test("subString") {
        val phoneNumber = "010-8802-5013"
        assertThat(phoneNumber.substringBefore("-")).isEqualTo("010")
        assertThat(phoneNumber.substringBeforeLast("-")).isEqualTo("010-8802")
        assertThat(phoneNumber.substringAfter("-")).isEqualTo("8802-5013")
        assertThat(phoneNumber.substringAfterLast("-")).isEqualTo("5013")
    }

    test("IntDistance") {
        val distance = IntDistance(0)
        println(distance.distance)
        println(distance.increment(10))
        println(distance.distance)
    }
})
