package com.inkwell.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// OLED True Black Theme
private val InkWellDarkColorScheme = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFFBB86FC),
    secondary = androidx.compose.ui.graphics.Color(0xFF03DAC6),
    tertiary = androidx.compose.ui.graphics.Color(0xFF3700B3),
    background = androidx.compose.ui.graphics.Color(0xFF000000), // True black for OLED
    surface = androidx.compose.ui.graphics.Color(0xFF121212),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF000000),
    onSecondary = androidx.compose.ui.graphics.Color(0xFF000000),
    onTertiary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    onBackground = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    onSurface = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    error = androidx.compose.ui.graphics.Color(0xFFCF6679),
    onError = androidx.compose.ui.graphics.Color(0xFF000000)
)

private val InkWellLightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF6200EE),
    secondary = androidx.compose.ui.graphics.Color(0xFF03DAC6),
    tertiary = androidx.compose.ui.graphics.Color(0xFF3700B3),
    background = androidx.compose.ui.graphics.Color(0xFFFFFBFE),
    surface = androidx.compose.ui.graphics.Color(0xFFFFFBFE),
    onPrimary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    onSecondary = androidx.compose.ui.graphics.Color(0xFF000000),
    onTertiary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    onBackground = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    onSurface = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    error = androidx.compose.ui.graphics.Color(0xFFBA1A1A),
    onError = androidx.compose.ui.graphics.Color(0xFFFFFFFF)
)

@Composable
fun InkWellTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> InkWellDarkColorScheme
        else -> InkWellLightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}
