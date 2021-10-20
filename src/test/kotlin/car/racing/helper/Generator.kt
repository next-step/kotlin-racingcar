package car.racing.helper

import car.racing.usecase.Generator

class AboveStandardGenerator : Generator<Int> {
    override fun generate(): Int {
        return 6
    }
}

class BelowStandardGenerator : Generator<Int> {
    override fun generate(): Int {
        return 0
    }
}
