package com.devhp.jetnews_app_clone.data.interests.impl

import com.devhp.jetnews_app_clone.data.Result
import com.devhp.jetnews_app_clone.data.interests.InterestSection
import com.devhp.jetnews_app_clone.data.interests.InterestsRepository
import com.devhp.jetnews_app_clone.data.interests.TopicSelection
import com.devhp.jetnews_app_clone.utils.addOrRemove
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeInterestsRepository : InterestsRepository {

    private val topics by lazy {
        listOf(
            InterestSection("Android", listOf("Jetpack Compose", "Kotlin", "Jetpack")),
            InterestSection(
                "Programming",
                listOf("Kotlin", "Declarative UIs", "Java", "Unidirectional Data Flow", "C++")
            ),
            InterestSection("Technology", listOf("Pixel", "Google"))
        )
    }


    private val people by lazy {
        listOf(
            "Kobalt Toral",
            "K'Kola Uvarek",
            "Kris Vriloc",
            "Grala Valdyr",
            "Kruel Valaxar",
            "L'Elij Venonn",
            "Kraag Solazarn",
            "Tava Targesh",
            "Kemarrin Muuda"
        )
    }

    private val publications by lazy {
        listOf(
            "Kotlin Vibe",
            "Compose Mix",
            "Compose Breakdown",
            "Android Pursue",
            "Kotlin Watchman",
            "Jetpack Ark",
            "Composeshack",
            "Jetpack Point",
            "Compose Tribune"
        )
    }

    // for now, keep the selections in memory
    private val selectedTopics = MutableStateFlow(setOf<TopicSelection>())
    private val selectedPeople = MutableStateFlow(setOf<String>())
    private val selectedPublications = MutableStateFlow(setOf<String>())

    override suspend fun getTopics(): Result<List<InterestSection>> {
        return Result.Success(topics)
    }

    override suspend fun getPeople(): Result<List<String>> {
        return Result.Success(people)
    }

    override suspend fun getPublications(): Result<List<String>> {
        return Result.Success(publications)
    }

    override suspend fun toggleTopicSelection(topic: TopicSelection) {
        selectedTopics.update {
            it.addOrRemove(topic)
        }
    }

    override suspend fun togglePersonSelected(person: String) {
        selectedPeople.update {
            it.addOrRemove(person)
        }
    }

    override suspend fun togglePublicationSelected(publication: String) {
        selectedPublications.update {
            it.addOrRemove(publication)
        }
    }

    override fun observeTopicsSelected(): Flow<Set<TopicSelection>> = selectedTopics
    override fun observePeopleSelected(): Flow<Set<String>> = selectedPeople

    override fun observePublicationSelected(): Flow<Set<String>> = selectedPublications
}