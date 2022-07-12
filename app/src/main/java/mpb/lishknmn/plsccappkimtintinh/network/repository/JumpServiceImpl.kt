package mpb.lishknmn.plsccappkimtintinh.network.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import mpb.lishknmn.plsccappkimtintinh.network.data.RequestModel
import mpb.lishknmn.plsccappkimtintinh.network.data.ResponseModel
import mpb.lishknmn.plsccappkimtintinh.network.di.RetrofitHelper

class JumpServiceImpl {

    private val service : JumpService = RetrofitHelper.service()

    suspend fun getJumpCodeUrl(param : RequestModel): Flow<ResponseModel> = callbackFlow {
        trySend(service.getJumpCode(param))
        awaitClose()
    }
}