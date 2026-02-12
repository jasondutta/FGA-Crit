package io.github.fate_grand_critomata.di.app

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.fate_grand_critomata.IStorageProvider
import io.github.fate_grand_critomata.prefs.PreferencesImpl
import io.github.fate_grand_critomata.scripts.IImageLoader
import io.github.fate_grand_critomata.scripts.prefs.IPreferences
import io.github.fate_grand_critomata.util.ImageLoader
import io.github.fate_grand_critomata.util.StorageProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppBindsModule {
    @Singleton
    @Binds
    fun bindImageLoader(imageLoader: ImageLoader): IImageLoader

    @Singleton
    @Binds
    fun bindPrefs(prefs: PreferencesImpl): IPreferences

    @Singleton
    @Binds
    fun bindStorageProvider(storageProvider: StorageProvider): IStorageProvider
}