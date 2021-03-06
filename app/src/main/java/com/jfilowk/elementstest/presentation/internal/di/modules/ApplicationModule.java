package com.jfilowk.elementstest.presentation.internal.di.modules;

import android.content.Context;
import com.jfilowk.elementstest.ElementTest;
import com.jfilowk.elementstest.data.cache.ItemCache;
import com.jfilowk.elementstest.data.cache.ItemCacheImpl;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityCsvMapper;
import com.jfilowk.elementstest.data.network.ElementsService;
import com.jfilowk.elementstest.data.network.ServiceGenerator;
import com.jfilowk.elementstest.data.repository.ItemDataRepository;
import com.jfilowk.elementstest.domain.MainThread;
import com.jfilowk.elementstest.domain.MainThreadImpl;
import com.jfilowk.elementstest.domain.repository.ItemRepository;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private ElementTest elementTest;

  public ApplicationModule(ElementTest elementTest) {
    this.elementTest = elementTest;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return elementTest.getApplicationContext();
  }

  @Provides @Singleton ExecutorService provideExecutor() {
    return Executors.newFixedThreadPool(2);
  }

  @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
    return mainThread;
  }

  @Provides @Singleton ServiceGenerator provideServiceGenerator() {
    return new ServiceGenerator("https://docs.google.com/spreadsheet/");
  }

  @Provides @Singleton ItemEntityCsvMapper provideItemEntityCsvMapper() {
    return new ItemEntityCsvMapper();
  }

  @Provides @Singleton ElementsService provideElementsService(Context context,
      ServiceGenerator serviceGenerator, ItemEntityCsvMapper itemEntityCsvMapper) {
    return new ElementsService(context, serviceGenerator, itemEntityCsvMapper);
  }

  @Provides @Singleton ItemCache provideItemCache(ItemCacheImpl itemCache) {
    return itemCache;
  }

  @Provides @Singleton ItemRepository provideItemRepository(ItemDataRepository itemDataRepository) {
    return itemDataRepository;
  }
}
