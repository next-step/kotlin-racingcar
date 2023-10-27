package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LearnRequire : StringSpec({

    "require 톺아보기" {
        println("true 일때는 아무일도 일어나지 않고")
        require(true)
        try {
            require(false)
        } catch (_: IllegalArgumentException) {
            println("false 일때는 exception throw")
        }
    }

    "메시지를 지정한다" {
        try {
            require(false) { "Error message" }
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
        }
    }

    "타입은 IllegalArgumentException" {
        shouldThrow<IllegalArgumentException> {
            require(false)
        }
    }
})
