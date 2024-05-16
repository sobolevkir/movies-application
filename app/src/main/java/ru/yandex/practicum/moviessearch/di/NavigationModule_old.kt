package ru.yandex.practicum.moviessearch.di

import org.koin.dsl.module
import ru.yandex.practicum.moviessearch.core.navigation_old.Router
import ru.yandex.practicum.moviessearch.core.navigation_old.RouterImpl


val navigationModule = module {
    val router = RouterImpl()

    single<Router> { router }
    single { router.navigatorHolder }
}
