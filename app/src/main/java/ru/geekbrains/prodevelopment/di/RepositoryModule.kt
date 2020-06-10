package ru.geekbrains.prodevelopment.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.datasource.DataSource
import ru.geekbrains.prodevelopment.model.datasource.RetrofitImplementation
import ru.geekbrains.prodevelopment.model.datasource.RoomDataBaseImplementation
import ru.geekbrains.prodevelopment.model.repository.IRepository
import ru.geekbrains.prodevelopment.model.repository.RepositoryImplementation
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): IRepository<List<DataModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): IRepository<List<DataModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImplementation()
}
