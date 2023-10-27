package study

import io.kotest.core.spec.style.StringSpec

class LearnZipReduce : StringSpec({

    val numbers1 = listOf(1, 2, 3, 4, 5)
    val numbers2 = listOf(6, 7, 8, 9, 10)

    "zip 을 사용해서 두 리스트를 결합하고 더하기" {
        val sumEach = numbers1.zip(numbers2) { a, b -> a + b }
        println("zip 을 활용해서 두 리스트를 더하면 \n $sumEach")
    }

    "reduce 를 사용해서 리스트의 모든 값을 더하기" {
        val sumTotal = numbers1.reduce { a, b -> a + b }
        println("reduce 을 활용해서 한 리스트의 모든 원소를 더한다 \n $numbers1 \n $sumTotal")
    }
})
