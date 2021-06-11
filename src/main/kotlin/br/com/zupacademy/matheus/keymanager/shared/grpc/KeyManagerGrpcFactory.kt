package br.com.zupacademy.matheus.keymanager.shared.grpc

import br.com.zupacademy.matheus.KeymanagerCarregaGrpcServiceGrpc
import br.com.zupacademy.matheus.KeymanagerListaGrpcServiceGrpc
import br.com.zupacademy.matheus.KeymanagerRegistraGrpcServiceGrpc
import br.com.zupacademy.matheus.KeymanagerRemoveGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class KeyManagerGrpcFactory(@GrpcChannel("keyManager") val channel: ManagedChannel) {

    @Singleton
    fun registraChave() = KeymanagerRegistraGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun deletaChave() = KeymanagerRemoveGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChaves() = KeymanagerListaGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun carregaChave() = KeymanagerCarregaGrpcServiceGrpc.newBlockingStub(channel)


}