package com.ElOuedUniv.maktaba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ElOuedUniv.maktaba.data.repository.BookRepository
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksUseCase
import com.ElOuedUniv.maktaba.presentation.screens.BookListScreen
import com.ElOuedUniv.maktaba.presentation.viewmodel.BookViewModel
import com.ElOuedUniv.maktaba.presentation.theme.MaktabaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = BookRepository()
        val useCase = GetBooksUseCase(repository)
        val viewModel = BookViewModel(useCase)

        setContent {
            MaktabaTheme {
                BookListScreen(viewModel = viewModel)
            }
        }
    }
}