package mpb.lishknmn.plsccappkimtintinh.network.repository

import mpb.lishknmn.plsccappkimtintinh.network.data.RequestModel
import mpb.lishknmn.plsccappkimtintinh.network.data.ResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface JumpService {

    @POST("app_conf")
    suspend fun getJumpCode(@Body param :RequestModel): ResponseModel

}