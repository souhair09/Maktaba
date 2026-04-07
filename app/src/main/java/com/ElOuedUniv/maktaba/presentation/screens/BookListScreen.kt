package com.ElOuedUniv.maktaba.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ElOuedUniv.maktaba.presentation.viewmodel.BookViewModel

@Composable
fun BookListScreen(
    viewModel: BookViewModel
) {
    val books by viewModel.books.collectAsState()
    val totalPages = viewModel.getTotalPages()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Total Books: ${books.size}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Total Pages: $totalPages",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (books.isEmpty()) {
            Text(text = "No books available")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(books) { book ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = book.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(text = "ISBN: ${book.isbn}")
                            Text(text = "Pages: ${book.nbPages}")
                        }
                    }
                }
            }
        }
    }
}