package com.devhp.jetnews_app_clone.data.posts.impl

import com.devhp.jetnews_app_clone.data.Result
import com.devhp.jetnews_app_clone.data.posts.PostsRepository
import com.devhp.jetnews_app_clone.model.Post
import com.devhp.jetnews_app_clone.model.PostsFeed
import com.devhp.jetnews_app_clone.utils.addOrRemove
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class FakePostsRepository : PostsRepository {
    // for now, store these in memory
    private val favorites = MutableStateFlow<Set<String>>(setOf())
    private val postsFeed = MutableStateFlow<PostsFeed?>(null)

    // Used to make suspend functions that read and update state safe to call from any thread

    override suspend fun getPost(postId: String?): Result<Post> {
        return withContext(Dispatchers.IO) {
            val post = posts.allPosts.find { it.id == postId }
            if (post == null) {
                Result.Error(IllegalArgumentException("Post not found"))
            } else {
                Result.Success(post)
            }
        }
    }

    override suspend fun getPostsFeed(): Result<PostsFeed> {
        return withContext(Dispatchers.IO) {
            delay(800)
            if (shouldRandomlyFail()) {
                Result.Error(IllegalArgumentException())
            } else {
                postsFeed.update { posts }
                Result.Success(posts)
            }
        }
    }

    override fun observeFavorites(): Flow<Set<String>> = favorites

    override fun observePostsFeed(): Flow<PostsFeed?> = postsFeed

    override suspend fun toggleFavorite(postId: String) {
        favorites.update {
            it.addOrRemove(postId)
        }
    }

    // used to drive "random" failure in a predictable pattern, making the first request always
    // succeed
    private var requestCount = 0

    /**
     * Randomly fail some loads to simulate a real network.
     * Randomly fail some loads to simulate a real network.
     *
     * This will fail deterministically every 5 requests
     */
    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}