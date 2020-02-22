package com.vasilevkin.catsanddogs

import com.vasilevkin.catsanddogs.features.animalList.IMainContract
import com.vasilevkin.catsanddogs.features.animalList.MainPresenter
import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.repository.IAnimalRepository
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    private lateinit var mockMainActivity: IMainContract.View

    private val dependencyInjector: IDependencyInjector = StubDependencyInjector()

    private var presenter: MainPresenter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(mockMainActivity, dependencyInjector)
    }

    @After
    fun tearDown() {
        presenter?.onDestroy()
    }

    @Test
    fun testOnViewCreatedFlow() {
        presenter?.onViewCreated()
        verify(mockMainActivity)
    }
}

class StubDependencyInjector : IDependencyInjector {

    override fun animalRepository(): IAnimalRepository {
        return StubAnimalRepository()
    }
}

class StubAnimalRepository : IAnimalRepository {

    override fun getAllAnimals(): Single<List<Animal>> {

        return Single.just(listOf(Animal("test title", "test subtitle", "test_image_url")))
    }
}
