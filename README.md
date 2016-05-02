The application has been developed using Clean Architecture. It consists in three layers: presentation, domain and data.

Presentation use Model View Presenter. Presenter decide which data is displayed. Data comes from Domain using Interactors which are implemented in the Domain layer

Basically, Interactors are the different use cases. In this case, we only have one GetItemListUseCase. In order to implement the detail, we need to implement a new one GetDetailItemUseCase. In this layer, we don’t usually have any Android Dependencies. Business logic here.

Last one is Data. It has a Repository Pattern and we implement all the datasources. I used SQLite3 to cache the list.

Application implements multithreading using Executors. The different use cases are implemented like Task (Runnable) and we execute them in 2 threads. Callbacks hooks the response and post it in the MainThread.

Libraries:

Butterknife
Timber
Retrofit
Dagger2
OpenCsv
Picasso