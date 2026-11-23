package com.sonms.ylog

import android.content.Context
import com.sonms.ylog.core.datastore.PREFERENCES_FILE
import com.sonms.ylog.di.AppGraph
import com.sonms.ylog.di.IMAGE_CACHE
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Named
import dev.zacsweers.metro.Provides
import okio.Path
import okio.Path.Companion.toOkioPath

/** Room, DataStore, 이미지 캐시 등이 Android `Context`를 필요로 하므로 Factory로 만든다. */
@DependencyGraph(AppScope::class)
interface AndroidAppGraph : AppGraph {
    @Provides
    @Named(IMAGE_CACHE)
    fun provideImageCacheDirectory(context: Context): Path = context.cacheDir.resolve("image_cache").toOkioPath()

    @Provides
    @Named(PREFERENCES_FILE)
    fun providePreferencesFile(context: Context): Path =
        context.filesDir.resolve("datastore/ylog.preferences_pb").toOkioPath()

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(@Provides context: Context): AndroidAppGraph
    }
}
