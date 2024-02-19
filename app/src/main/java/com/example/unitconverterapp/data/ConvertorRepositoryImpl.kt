package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConvertorRepositoryImpl(private val dao: ConverterDAO): ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllresults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
       return dao.getResults()
    }
}