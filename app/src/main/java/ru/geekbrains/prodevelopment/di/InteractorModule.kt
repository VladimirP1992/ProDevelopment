package ru.geekbrains.prodevelopment.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.repository.IRepository
import ru.geekbrains.prodevelopment.viewmodel.interactor.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: IRepository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: IRepository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
