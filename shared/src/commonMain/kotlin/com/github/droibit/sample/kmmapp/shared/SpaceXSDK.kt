package com.github.droibit.sample.kmmapp.shared

import com.github.droibit.sample.kmmapp.shared.cache.Database
import com.github.droibit.sample.kmmapp.shared.cache.DatabaseDriverFactory
import com.github.droibit.sample.kmmapp.shared.entity.RocketLaunch
import com.github.droibit.sample.kmmapp.shared.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            return cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}