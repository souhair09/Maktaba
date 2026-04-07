package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

class BookRepository {

    private val booksList = listOf(
        Book(
            isbn = "978-0-13-235088-4",
            title = "Clean Code",
            nbPages = 464
        ),
        Book(
            isbn = "978-0-201-61622-4",
            title = "The Pragmatic Programmer",
            nbPages = 352
        ),
        Book(
            isbn = "978-0-596-52068-7",
            title = "Head First Design Patterns",
            nbPages = 694
        ),
        Book(
            isbn = "978-1-491-92442-7",
            title = "Kotlin in Action",
            nbPages = 360
        ),
        Book(
            isbn = "978-0-321-35668-0",
            title = "Effective Java",
            nbPages = 416
        ),
        Book(
            isbn = "978-0-262-03384-8",
            title = "Introduction to Algorithms",
            nbPages = 1312
        ),
        Book(
            isbn = "978-0-07-352340-8",
            title = "Database System Concepts",
            nbPages = 1376
        ),
        Book(
            isbn = "978-1-118-95214-6",
            title = "Android Programming",
            nbPages = 832
        ),
        Book(
            isbn = "978-0-13-468599-1",
            title = "Effective Java Programming",
            nbPages = 412
        ),
        Book(
            isbn = "978-1-59327-599-0",
            title = "Automate the Boring Stuff with Python",
            nbPages = 504
        )
    )

    fun getAllBooks(): List<Book> {
        return booksList
    }

    fun searchBooksByTitle(query: String): List<Book> {
        return booksList.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    fun getLongBooks(): List<Book> {
        return booksList.filter { it.nbPages > 400 }
    }
}