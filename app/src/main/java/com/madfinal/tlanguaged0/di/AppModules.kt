package com.madfinal.tlanguaged0.di

import com.madfinal.tlanguaged0.data.datasource.network.supabase.builder.SupabaseNetworkBuilder
import com.madfinal.tlanguaged0.data.main.repository.MainRepositoryImpl
import com.madfinal.tlanguaged0.data.onboarding.OnboardingRepositoryImpl
import com.madfinal.tlanguaged0.domain.main.repository.MainRepository
import com.madfinal.tlanguaged0.domain.main.usecase.GetTopUsersUseCase
import com.madfinal.tlanguaged0.domain.onboarding.repository.OnboardingRepository
import com.madfinal.tlanguaged0.domain.onboarding.usecase.GetOnboardingItemsUseCase
import com.madfinal.tlanguaged0.presentation.main.MainViewModel
import com.madfinal.tlanguaged0.presentation.onboarding.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single<String>(qualifier = named("supabaseUrl")) { "https://mngcisyjmvbmebnlapht.supabase.co" }
    single<String>(qualifier = named("supabaseApiKey")) {
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1uZ2Npc3lqbXZibWVibmxhcGh0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzAxOTAyMDIsImV4cCI6MjA0NTc2NjIwMn0.MFGhx41ZSshllA0x677E_sy3nFOcjZG-HFuTNE8yBz4"
    }
    single(qualifier = named("supabaseClient")) {
        SupabaseNetworkBuilder.provideOkHttp(
            get(named("supabaseApiKey"))
        )
    }



    single {
        SupabaseNetworkBuilder.provideRetrofit(
            get(qualifier = named("supabaseUrl")),
            get(qualifier = named("supabaseClient"))
        )
    }

    single { SupabaseNetworkBuilder.provideSupabaseClient(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { OnboardingViewModel(get()) }
}

val useCasesModule = module {
    single { GetTopUsersUseCase(get()) }
    single { GetOnboardingItemsUseCase(get()) }
}

val repositoryModule = module {
    single<OnboardingRepository> { OnboardingRepositoryImpl() }
    single<MainRepository> { MainRepositoryImpl(get()) }
}
val appModules = listOf(
    networkModule,
    viewModelModule,
    useCasesModule,
    repositoryModule
)