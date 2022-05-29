package _3_racing_car.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row

internal class NameTest : ExpectSpec() {
    init {
        context("init") {
            expect("공백으로 이름을 지을수 없다.") {
                forAll(
                    row(" "),
                    row(""),
                    row("\n"),
                ) { value ->
                    shouldThrow<IllegalArgumentException> { Name(value) }
                }
            }

            expect("이름의 최대 5자를 초과할 수 없다.") {
                shouldThrow<IllegalArgumentException> { Name("a".repeat(6)) }
            }
        }
    }
}
