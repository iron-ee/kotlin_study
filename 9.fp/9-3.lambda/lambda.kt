package main.kotlin.fp.lambda

import main.java.reference.lec17.Fruit


val fruits = listOf(
    Fruit("사과", 3_000),
    Fruit("바나나", 1_500),
    Fruit("딸기", 5_000),
    Fruit("포도", 4_000),
    Fruit("수박", 7_000),
    Fruit("오렌지", 4_000),
    Fruit("참외", 3_000),
)

// 람다를 만드는 방법 1
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

// 람다를 만드는 방법 2
val isApple2 = { fruit: Fruit -> fruit.name == "사과"}

// 함수의 타입 : (파라미터 타입) -> 반환 타입
val isApple3: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

val isApple4: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}


private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()

    for(fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}





fun main() {
    isApple(fruits[0])
    isApple.invoke(fruits[0])

    // 람다를 직접 호출하는 방법 1
    isApple(Fruit("사과", 2_000))
    // 람다를 직접 호출하는 방법 2
    isApple.invoke(Fruit("바나나", 1_000))

    //
    filterFruits(fruits, isApple)
    filterFruits(fruits, isApple2)
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    filterFruits(fruits) { fruit ->     // 람다를 여러줄 작성가능
        println("사과만 받는중~!")
        fruit.name == "사과"  // 그리고 마지막 줄의 결과가 람다의 반환값
    }
    filterFruits(fruits) { it.name == "사과" }    // 익명 함수일 때, 파라미터가 한 개인 경우 it 을 사용할 수 있다.
}



/*
코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있음
이렇게 해야만, 람다를 진정한 일급 객체로 간주할 수 있다.
이 데이터 구조를 Closure 라고 칭함
 */

/*
함수는 java 에서는 2급 객체였지만, kotlin 에서는 1급 객체이다.
-> 때문에, 함수 자체를 변수에 넣을 수도 있고 파라미터로 전달할 수도 있다.
kotlin 에서 함수 타입은 (파라미터 타입) -> 반환타입
함수를 호출하며, 마지막 파라미터인 람다를 쓸 때는 소괄호 밖으로 람다를 뺄 수 있다.
람다의 마지막 expression 결과는 람다의 반환 값이다.
kotlin 에서는 Closure 를 사용하여 non-final 변수도 람다에서 사용할 수 있다.
 */