package com.android.com.kotlin.one

fun runTest(name: String, block: () -> Boolean) {
    try {
        check(block()) { "❌ Test failed: $name" }
        println("✅ $name")
    } catch (e: Throwable) {
        println("❌ $name → ${e.message}")
    }
}

// Exercise 1 — Immutable List
fun ex1CreateImmutableList(): List<Int> {
    return listOf(1, 2, 3, 4, 5)
}

// Exercise 2 — Mutable List
fun ex2CreateMutableList(): List<String> {
    val list = mutableListOf("Kotlin", "Java", "Python")
    list.add("Swift")
    return list
}

// Exercise 3 — Filter Even
fun ex3FilterEvenNumbers(): List<Int> {
    return (1..10).filter { it % 2 == 0 }
}

// Exercise 4 — Filter and Map
fun ex4FilterAndMapAges(ages: List<Int>): List<String> {
    return ages
        .filter { it >= 18 }
        .map { "Adult: $it" }
}

// Exercise 5 — Flatten Nested Lists
fun ex5FlattenList(): List<Int> {
    val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5))
    return nested.flatten()
}

// Exercise 6 — FlatMap
fun ex6FlatMapWords(): List<String> {
    val phrases = listOf("Kotlin is fun", "I love lists")
    return phrases.flatMap { it.split(" ") }
}

// Exercise 7 — Eager Processing
fun ex7EagerProcessing(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .toList()
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)

    val end = System.currentTimeMillis()
    println("Eager  time: ${end - start} ms")

    return result
}

// Exercise 8 — Lazy Processing
fun ex8LazyProcessing(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .asSequence()
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)
        .toList()

    val end = System.currentTimeMillis()
    println("Lazy   time: ${end - start} ms")

    return result
}

// Exercise 9 — Chain multiple operations
fun ex9FilterAndSortNames(names: List<String>): List<String> {
    return names
        .filter { it.startsWith("A") }
        .map { it.uppercase() }
        .sorted()
}

fun main() {
    //TODO("Pour cette leçon, suivez les instructions dans le fichier README_02.md")
    println("🔍 Running Kotlin List Processing Tests...\n")

    // Exercise 1
    runTest("ex1 - Immutable list has 5 elements") {
        ex1CreateImmutableList().size == 5
    }
    runTest("ex1 - List is immutable (List<Int>)") {
        ex1CreateImmutableList() is List<Int>
    }

    // Exercise 2
    runTest("ex2 - Mutable list has 4 elements after add") {
        ex2CreateMutableList().size == 4
    }
    runTest("ex2 - Last element is 'Swift'") {
        ex2CreateMutableList().last() == "Swift"
    }

    // Exercise 3
    runTest("ex3 - Even numbers from 1 to 10") {
        ex3FilterEvenNumbers() == listOf(2, 4, 6, 8, 10)
    }

    // Exercise 4
    val ages = listOf(12, 17, 18, 25, 30, 15, 22)
    runTest("ex4 - Filter and map ages") {
        ex4FilterAndMapAges(ages) == listOf(
            "Adult: 18", "Adult: 25", "Adult: 30", "Adult: 22"
        )
    }

    // Exercise 5
    runTest("ex5 - Flattened list") {
        ex5FlattenList() == listOf(1, 2, 3, 4, 5)
    }

    // Exercise 6
    runTest("ex6 - FlatMap words") {
        ex6FlatMapWords() == listOf("Kotlin", "is", "fun", "I", "love", "lists")
    }

    // Exercise 7 & 8
    val eagerResult = ex7EagerProcessing()
    val lazyResult  = ex8LazyProcessing()

    runTest("ex7 - Eager: first 5 squares divisible by 3") {
        eagerResult == listOf(9, 36, 81, 144, 225)
    }
    runTest("ex8 - Lazy: same result as eager") {
        lazyResult == eagerResult
    }

    // Exercise 9
    val names = listOf("Alice", "Bob", "Anna", "Charlie", "Alex", "Diana")
    runTest("ex9 - Filter, uppercase, sort names starting with A") {
        ex9FilterAndSortNames(names) == listOf("ALEX", "ALICE", "ANNA")
    }

    println("\n🎯 Done!")
}