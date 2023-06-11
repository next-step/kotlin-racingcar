package step3.fake

import step3.domain.NumberGenerator

class NumberGeneratorGreaterThan4 : NumberGenerator {
    override fun generate(): Int {
        return 4
    }
}

class NumberGeneratorLessThan4 : NumberGenerator {
    override fun generate(): Int {
        return 2
    }
}
