package com.jfilowk.elementstest.presentation.internal.di.modules;

import com.jfilowk.elementstest.domain.interactor.GetItemListUseCase;
import com.jfilowk.elementstest.domain.interactor.GetItemListUseCaseImpl;
import com.jfilowk.elementstest.presentation.internal.di.PerActivity;
import com.jfilowk.elementstest.presentation.list_csv.ItemListPresenter;
import com.jfilowk.elementstest.presentation.list_csv.ItemListPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module public class ItemModule {

  @Provides @PerActivity GetItemListUseCase provideGetItemListUseCase(
      GetItemListUseCaseImpl getItemListUseCase) {
    return getItemListUseCase;
  }

  @Provides @PerActivity ItemListPresenter provideItemsListPresenter(
      ItemListPresenterImpl itemsListPresenter) {
    return itemsListPresenter;
  }
}
