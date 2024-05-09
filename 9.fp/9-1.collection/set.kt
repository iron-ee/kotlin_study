package main.kotlin.fp.collection

// 집합은 List 와 다르게 순서가 없고, 같은 element 는 하나만 존재할 수 있음
// 자료구조적 의미만 제외하면 모든 기능이 List 와 비슷함

fun set() {

    val numbers = setOf(100, 200, 300, 400)

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 for문
    for ((idx, number) in numbers.withIndex()) {
        println("${idx} ${number}")
    }

    // 가변 집합 -> mutableSetOf   / 기본 구현체는 LinkedHashSet 사용
    val numbers2 = mutableSetOf(100, 200, 300, 400)
}
