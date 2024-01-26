package com.devhp.jetnews_app_clone.ui.theme

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


val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    inversePrimary = md_theme_light_inversePrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    surfaceTint = md_theme_light_surfaceTint,
    inverseSurface = md_theme_light_inverseSurface,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    errorContainer = md_theme_light_errorContainer,
    onErrorContainer = md_theme_light_onErrorContainer,
    outline = md_theme_light_outline,
    )

val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    inversePrimary = md_theme_dark_inversePrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    surfaceTint = md_theme_light_surfaceTint,
    inverseSurface = md_theme_dark_inverseSurface,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    errorContainer = md_theme_dark_errorContainer,
    onErrorContainer = md_theme_dark_onErrorContainer,
    outline = md_theme_light_outline,
)

@Composable
fun JetNewsCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (darkTheme) DarkColors else LightColors
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
        shapes = JetnewsShapes,
        typography = Typography,
        content = content
    )
}

/*Hàm `lightColorScheme` trong Jetpack Compose nhận vào một loạt các màu sắc và trả về một `ColorScheme`. Dưới đây là giải thích chi tiết về từng màu:

1. `primary`: Màu chính của chủ đề, thường được sử dụng cho các thành phần tương tác như nút, liên kết, v.v.
2. `onPrimary`: Màu được sử dụng cho văn bản và biểu tượng khi chúng xuất hiện trên màu chính.
3. `primaryContainer`: Màu của các container chính.
4. `onPrimaryContainer`: Màu của văn bản hoặc biểu tượng khi chúng xuất hiện trên `primaryContainer`.
5. `inversePrimary`: Màu ngược lại với màu chính.
6. `secondary`: Màu phụ, thường được sử dụng để nhấn mạnh các thành phần tương tác khác.
7. `onSecondary`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên màu phụ.
8. `secondaryContainer`: Màu của các container phụ.
9. `onSecondaryContainer`: Màu của văn bản hoặc biểu tượng khi chúng xuất hiện trên `secondaryContainer`.
10. `tertiary`: Màu thứ ba, thường được sử dụng cho các thành phần không quan trọng hoặc không cần tập trung.
11. `onTertiary`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên màu thứ ba.
12. `tertiaryContainer`: Màu của các container thứ ba.
13. `onTertiaryContainer`: Màu của văn bản hoặc biểu tượng khi chúng xuất hiện trên `tertiaryContainer`.
14. `background`: Màu nền của giao diện người dùng.
15. `onBackground`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên nền.
16. `surface`: Màu của các bề mặt chính như card, sheet, v.v.
17. `onSurface`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên bề mặt.
18. `surfaceVariant`: Một biến thể của màu bề mặt.
19. `onSurfaceVariant`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên `surfaceVariant`.
20. `surfaceTint`: Một màu nhẹ hơn của bề mặt.
21. `inverseSurface`: Màu ngược lại với màu bề mặt.
22. `inverseOnSurface`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên `inverseSurface`.
23. `error`: Màu được sử dụng để chỉ ra lỗi hoặc trạng thái lỗi.
24. `onError`: Màu của văn bản và biểu tượng khi chúng xuất hiện trên màu lỗi.
25. `errorContainer`: Màu của các container lỗi.
26. `onErrorContainer`: Màu của văn bản hoặc biểu tượng khi chúng xuất hiện trên `errorContainer`.
27. `outline`: Màu của đường viền.
28. `outlineVariant`: Một biến thể của màu đường viền.
29. `scrim`: Màu của scrim, một lớp mờ thường được sử dụng khi hiển thị các dialog hoặc menu¹.

Hy vọng giải thích của tôi giúp bạn hiểu rõ hơn về `lightColorScheme`! Nếu bạn có thêm câu hỏi, đừng ngần ngại liên hệ với tôi! 😊

Source: Conversation with Bing, 1/23/2024
(1) Material Design 3 in Compose | Jetpack Compose | Android Developers. https://developer.android.com/jetpack/compose/designsystems/material3.
(2) Theming in Compose with Material 3 | Android Developers. https://developer.android.com/codelabs/jetpack-compose-theming.
(3) change background color surface light/dark jetpack compose. https://stackoverflow.com/questions/74988479/change-background-color-surface-light-dark-jetpack-compose.
(4) Material3 theme in jetpack compose gives different color. https://stackoverflow.com/questions/76753884/material3-theme-in-jetpack-compose-gives-different-color.
(5) How do I use Color resource directly in Jetpack Compose?. https://stackoverflow.com/questions/64988112/how-do-i-use-color-resource-directly-in-jetpack-compose.Hàm `lightColorScheme` trong Jetpack Compose nhận vào một loạt các màu sắc và trả về một `ColorScheme`. Dưới đây là giải thích chi tiết về từng màu:
*/