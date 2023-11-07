package study

import io.kotest.core.spec.style.StringSpec

class LearnDelegation : StringSpec({

    "Delegation 기본1" {
        val b = BaseImpl(10)
        Derived(b).print()
    }
})

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(b: Base) : Base by b
