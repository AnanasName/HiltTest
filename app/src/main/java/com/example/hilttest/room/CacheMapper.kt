package com.example.hilttest.room

import com.example.hilttest.model.Blog
import com.example.hilttest.util.EntityMapper
import org.w3c.dom.Entity
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<BlogCacheEntity, Blog>{

    override fun mapFromEntity(entity: BlogCacheEntity): Blog
        = Blog(
                id = entity.id,
                title = entity.title,
                body = entity.body,
                category = entity.category,
                image = entity.image
        )


    override fun mapToEntity(domainModel: Blog): BlogCacheEntity
            = BlogCacheEntity(
                id = domainModel.id,
                title = domainModel.title,
                body = domainModel.body,
                category = domainModel.category,
                image = domainModel.image)


    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog> = entities.map{mapFromEntity(it)}
}