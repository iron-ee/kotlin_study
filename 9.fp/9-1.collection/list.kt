package main.kotlin.fp.collection

/*
컬렉션을 만들어줄 때 불변인지, 가변인지를 설정해야 한다.
- 가변(Mutable) 컬렉션 : 컬렉션에 element 를 추가, 삭제할 수 있다.
- 불면 컬렉션 : 컬렉션에 element 를 추가, 삭제할 수 없다.
불변 컬렉션이라 하더라도 Reference Type 인 Element 의 필드는 바꿀 수 있다.
ex) [Money(price=1000), Money(price=2000)] -> [Money(price=5000), Money(price=2000)]

kotlin 은 불변/가변을 지정해 주어야 한다는 사실을 명심
 */

fun list() {

    val numbers = listOf(100, 200, 300, 400)
    val emptyList = emptyList<Int>()    // 비어있는 리스트를 선언할 때는 Type 도 먼저 선언해줘야 함
                                        // 물론 추론이 가능한 경우면 생략도 가능함.

    // 가져오는 방법들
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문 느낌
    for ((idx, number) in numbers.withIndex()) {
        println("${idx} ${number}")
    }

    // 가변 리스트 -> mutableListOf   / 기본 구현체는 ArrayList 사용
    val numbers2 = mutableListOf(100, 200, 300, 400)
    numbers2.add(500)
    println("numbers2 = ${numbers2.toList()}")
}

// tip. 우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자.