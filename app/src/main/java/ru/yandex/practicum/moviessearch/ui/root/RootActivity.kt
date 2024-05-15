package ru.yandex.practicum.moviessearch.ui.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import ru.yandex.practicum.moviessearch.R
import ru.yandex.practicum.moviessearch.core.navigation.NavigatorHolder
import ru.yandex.practicum.moviessearch.core.navigation.NavigatorImpl
import ru.yandex.practicum.moviessearch.databinding.ActivityRootBinding
import ru.yandex.practicum.moviessearch.ui.movies.MoviesFragment


class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding

    // Заинжектили NavigatorHolder,
    // чтобы прикрепить к нему Navigator
    private val navigatorHolder: NavigatorHolder by inject()

    // Создали Navigator
    private val navigator = NavigatorImpl(
        fragmentContainerViewId = R.id.rootFragmentContainerView,
        fragmentManager = supportFragmentManager
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Привязываем вёрстку к экрану
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // С помощью навигатора открываем первый экран
            navigator.openFragment(
                MoviesFragment()
            )
        }
    }

    // Прикрепляем Navigator к NavigatorHolder
    override fun onResume() {
        super.onResume()
        navigatorHolder.attachNavigator(navigator)
    }

    // Открепляем Navigator от NavigatorHolder
    override fun onPause() {
        super.onPause()
        navigatorHolder.detachNavigator()
    }

}
