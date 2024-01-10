package com.devhp.jetnews_app_clone.data.posts

import com.devhp.jetnews_app_clone.model.Post
import com.devhp.jetnews_app_clone.model.PostsFeed
import kotlinx.coroutines.flow.Flow


interface PostsRepository {
    /*
    * Get a specific JetNews posts.
    * */
    suspend fun getPost(postId: String?): com.devhp.jetnews_app_clone.data.Result<Post>

    /*
    * Get JetNews posts.
    * */
    suspend fun getPostsFeed(): com.devhp.jetnews_app_clone.data.Result<PostsFeed>

    /*
    * Observe the current favorites
    * */
    fun observeFavorites(): Flow<Set<String>>

    /**
     * Observe the posts feed.
     */
    fun observePostsFeed(): Flow<PostsFeed?>

    /*
    * Toggle a postId to be a favorite or not.
    * */
    suspend fun toggleFavorite(postId: String)

}