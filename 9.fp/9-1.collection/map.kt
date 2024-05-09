package main.kotlin.fp.collection

// kotlin 도 동일하게 MutableMap 을 만들어 넣을 수도 있고,
// 정적 팩토리 메소드를 바로 활용할 수도 있다.

fun map() {

    val map = mutableMapOf<Int, String>()

    map.put(1, "Monday")    // 기존에 java 에서 사용한 put 도 사용 가능
    map[2] = "Tuesday"      // kotlin 에서는 이 방법으로 사용

    // 불변 map -> mapOf(key to value)
    mapOf(1 to "Wednesday", 2 to "Thursday")    // 중위 호출 to 를 사용함


    // 꺼내쓰기
    for (key in map.keys) {
        println(key)
        println(map.get(key))
        println(map[key])
    }

    for ((key, value) in map.entries) {
        println(key)
        println(value)
    }
}
