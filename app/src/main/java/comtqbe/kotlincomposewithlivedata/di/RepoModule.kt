package comtqbe.kotlincomposewithlivedata.di

import comtqbe.kotlincomposewithlivedata.store.data.repo.ProductRepoImpl
import comtqbe.kotlincomposewithlivedata.store.domain.repo.ProductsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindProductRepo(impl: ProductRepoImpl): ProductsRepo
}