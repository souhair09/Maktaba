package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.data.repository.BookRepository

class GetBooksUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(): List<Book> {
        return repository.getAllBooks()
    }
}