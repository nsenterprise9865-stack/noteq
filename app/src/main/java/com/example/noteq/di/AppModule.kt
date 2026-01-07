package com.example.noteq.di

import androidx.lifecycle.ViewModel

import com.example.noteq.viewmodel.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { NoteViewModel() }
}
